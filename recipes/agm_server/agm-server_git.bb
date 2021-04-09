inherit autotools pkgconfig update-rc.d qprebuilt

DESCRIPTION = "agm server"
SECTION = "multimedia"
LICENSE = "BSD"
LIC_FILES_CHKSUM = "file://${COREBASE}/meta/files/common-licenses/\
${LICENSE};md5=3775480a712fc46a69647678acb234cb"

DEPENDS = "glib-2.0 libutils libcutils agm dbus"

FILESPATH   =+ "${WORKSPACE}/:"
SRC_URI     =  "file://vendor/qcom/opensource/agm/ipc/DBus/agm_server"
SRC_URI     += "file://agm_server.service"
SRC_URI     += "file://agm-dbus.conf"
S = "${WORKDIR}/vendor/qcom/opensource/agm/ipc/DBus/agm_server"

PR = "r0"

EXTRA_OECONF += "--with-glib"

SOLIBS = ".so"
FILES_SOLIBSDEV = ""

FILES_${PN}-dbg  = "${libdir}/.debug/*"
FILES_${PN}      = "${libdir}/*.so ${libdir}/*.so.* ${sysconfdir}/* ${libdir}/pkgconfig/* ${bindir}/* ${sbindir}/*"
FILES_${PN}-dev  = "${libdir}/*.la ${includedir}"

INITSCRIPT_NAME = "agmserver"
INITSCRIPT_PARAMS = "start 45 2 3 4 5 . stop 80 0 1 6 ."

do_install_append () {
    if ${@bb.utils.contains('DISTRO_FEATURES', 'systemd', 'true', 'false', d)}; then
        install -m 0644 ${WORKDIR}/agm_server.service -D ${D}${sysconfdir}/systemd/system/agm_server.service
        install -d ${D}${sysconfdir}/systemd/system/multi-user.target.wants/
        ln -sf /etc/systemd/system/agm_server.service \
                          ${D}/etc/systemd/system/multi-user.target.wants/agm_server.service
        install -m 0644 ${WORKDIR}/agm-dbus.conf -D ${D}${sysconfdir}/dbus-1/system.d/agm-dbus.conf
    else
        install -m 0755 ${S}/src/agm_server -D ${D}${sysconfdir}/init.d/agm_server
    fi
}

RM_WORK_EXCLUDE += "${PN}"
