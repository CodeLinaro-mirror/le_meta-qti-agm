inherit autotools pkgconfig update-rc.d qprebuilt

DESCRIPTION = "agm server"
SECTION = "multimedia"
LICENSE = "BSD-3-Clause"
LIC_FILES_CHKSUM = "file://${COREBASE}/meta/files/common-licenses/\
${LICENSE};md5=550794465ba0ec5312d6919e203a55f9"

DEPENDS = "glib-2.0 libutils libcutils agm dbus"

FILESPATH   =+ "${WORKSPACE}/:"
SRC_URI     =  "file://vendor/qcom/opensource/agm/ipc/DBus/agm_server"
SRC_URI     += "file://${BASEMACHINE}/"
SRC_URI     += "file://agm_server.service"
SRC_URI     += "file://agm-dbus.conf"
S = "${WORKDIR}/vendor/qcom/opensource/agm/ipc/DBus/agm_server"

PR = "r0"

EXTRA_OECONF += "--with-glib"

SOLIBS = ".so"
FILES_SOLIBSDEV = ""

FILES:${PN}-dbg  = "${libdir}/.debug/*"
FILES:${PN}      = "${libdir}/*.so ${libdir}/*.so.* ${sysconfdir}/* ${libdir}/pkgconfig/* ${bindir}/* ${sbindir}/*"
FILES:${PN}-dev  = "${libdir}/*.la ${includedir}"

INITSCRIPT_NAME = "agmserver"
INITSCRIPT_PARAMS = "start 45 2 3 4 5 . stop 80 0 1 6 ."

do_install:append () {
    if ${@bb.utils.contains('DISTRO_FEATURES', 'systemd', 'true', 'false', d)}; then
        install -m 0644 ${WORKDIR}/${BASEMACHINE}/agm_server.service -D ${D}${sysconfdir}/systemd/system/agm_server.service
        install -d ${D}${sysconfdir}/systemd/system/multi-user.target.wants/
        ln -sf /etc/systemd/system/agm_server.service \
                          ${D}/etc/systemd/system/multi-user.target.wants/agm_server.service
        install -m 0644 ${WORKDIR}/${BASEMACHANE}/agm-dbus.conf -D ${D}${sysconfdir}/dbus-1/system.d/agm-dbus.conf
    else
        install -m 0755 ${S}/src/agm_server -D ${D}${sysconfdir}/init.d/agm_server
    fi
}

RM_WORK_EXCLUDE += "${PN}"
