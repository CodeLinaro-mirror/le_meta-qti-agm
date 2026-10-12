inherit autotools pkgconfig update-rc.d qprebuilt

DESCRIPTION = "agm sw binder server"
SECTION = "multimedia"
LICENSE = "BSD-3-Clause"
LIC_FILES_CHKSUM = "file://${COREBASE}/meta/files/common-licenses/\
${LICENSE};md5=550794465ba0ec5312d6919e203a55f9"

PR = "r0"

FILESPATH   =+ "${WORKSPACE}:"
SRC_URI     =  "file://vendor/qcom/opensource/agm/ipc/SwBinders/agm_server/"
SRC_URI     += "file://${BASEMACHINE}/"
SRC_URI     += "file://agm_binder_server.service"
DEPENDS = "libutils libcutils binder agm glib-2.0 audio-log-utils"
EXTRA_OECONF += "--with-glib"
SOLIBS = ".so"
FILES_SOLIBSDEV = ""


S = "${WORKDIR}/vendor/qcom/opensource/agm/ipc/SwBinders/agm_server/"

FILES:${PN}-dbg  = "${libdir}/.debug/*"
FILES:${PN}      = "${libdir}/*.so ${libdir}/*.so.* ${sysconfdir}/* ${libdir}/pkgconfig/* ${bindir}/* ${sbindir}/*"
FILES:${PN}-dev  = "${libdir}/*.la ${includedir}"

INITSCRIPT_NAME = "agmserver"
INITSCRIPT_PARAMS = "start 25 2 3 4 5 . stop 74 0 1 6 ."

do_install:append () {
    if ${@bb.utils.contains('DISTRO_FEATURES', 'systemd', 'true', 'false', d)}; then
        install -m 0644 ${WORKDIR}/${BASEMACHINE}/agm_binder_server.service -D ${D}${sysconfdir}/systemd/system/agm_binder_server.service
        agm_service=${D}${sysconfdir}/systemd/system/agm_binder_server.service
        append_supplementary_group() {
            group="$1"
            if grep -q '^SupplementaryGroups=' ${agm_service}; then
                grep -q "^SupplementaryGroups=.*${group}" ${agm_service} || \
                    sed -i "s/^\(SupplementaryGroups=.*\)/\1 ${group}/" ${agm_service}
            else
                sed -i "/^Group=/a SupplementaryGroups=${group}" ${agm_service}
            fi
        }

        if ${@bb.utils.contains('PACKAGECONFIG', 'clog_logging_enabled', 'true', 'false', d)}; then
            for group in ${CLOG_SUPPLEMENTARY_GROUPS}; do
                append_supplementary_group ${group}
            done
        elif ${@bb.utils.contains('PACKAGECONFIG', 'dlt_logging_enabled', 'true', 'false', d)}; then
            grep -q '^After=dlt.service$' ${agm_service} || \
                sed -i '/^\[Unit\]/a After=dlt.service' ${agm_service}
            append_supplementary_group dlt
        fi
        install -d ${D}${sysconfdir}/systemd/system/multi-user.target.wants/
        ln -sf /etc/systemd/system/agm_binder_server.service \
            ${D}/etc/systemd/system/multi-user.target.wants/agm_binder_server.service
    else
        install -m 0755 ${S}/src/agm_server -D ${D}${sysconfdir}/init.d/agm_server
    fi
}

# This is appended to enable commonlog (CLOG) logging feature
PACKAGECONFIG += "${@bb.utils.contains('MACHINE_FEATURES', 'commonlog', 'clog_logging_enabled', '', d)}"
require ${@bb.utils.contains('PACKAGECONFIG', 'clog_logging_enabled', 'recipes-extended/commonlog/clog-common.inc', '', d)}

# This is appended to enable dlt-logging feature
PACKAGECONFIG += "${@bb.utils.contains('MACHINE_FEATURES', 'dlt-logging', 'dlt_logging_enabled', '', d)}"
PACKAGECONFIG[clog_logging_enabled] = "--with-clog, ,commonlog-lib,commonlog-lib"
PACKAGECONFIG[dlt_logging_enabled] = "--with-dltlogging, ,dlt-daemon,dlt-daemon"

RM_WORK_EXCLUDE += "${PN}"
