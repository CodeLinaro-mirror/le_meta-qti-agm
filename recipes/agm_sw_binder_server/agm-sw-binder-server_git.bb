inherit autotools pkgconfig update-rc.d qprebuilt

DESCRIPTION = "agm sw binder server"
SECTION = "multimedia"
LICENSE = "BSD-3-Clause-Clear"
LIC_FILES_CHKSUM = "file://${COREBASE}/meta/files/common-licenses/BSD;md5=3775480a712fc46a69647678acb234cb"

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

FILES_${PN}-dbg  = "${libdir}/.debug/*"
FILES_${PN}      = "${libdir}/*.so ${libdir}/*.so.* ${sysconfdir}/* ${libdir}/pkgconfig/* ${bindir}/* ${sbindir}/*"
FILES_${PN}-dev  = "${libdir}/*.la ${includedir}"

INITSCRIPT_NAME = "agmserver"
INITSCRIPT_PARAMS = "start 25 2 3 4 5 . stop 74 0 1 6 ."

do_install_append () {
    if ${@bb.utils.contains('DISTRO_FEATURES', 'systemd', 'true', 'false', d)}; then
        install -m 0644 ${WORKDIR}/agm_binder_server.service -D ${D}${sysconfdir}/systemd/system/agm_binder_server.service
        install -d ${D}${sysconfdir}/systemd/system/multi-user.target.wants/
        ln -sf /etc/systemd/system/agm_binder_server.service \
            ${D}/etc/systemd/system/multi-user.target.wants/agm_binder_server.service
    else
        install -m 0755 ${S}/src/agm_server -D ${D}${sysconfdir}/init.d/agm_server
    fi
}

RM_WORK_EXCLUDE += "${PN}"
