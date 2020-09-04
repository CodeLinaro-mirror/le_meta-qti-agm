inherit autotools pkgconfig qprebuilt

DESCRIPTION = "agm services Library"
SECTION = "multimedia"
LICENSE = "BSD"
LIC_FILES_CHKSUM = "file://${COREBASE}/meta/files/common-licenses/\
${LICENSE};md5=3775480a712fc46a69647678acb234cb"

PR = "r0"

SRC_DIR     =  "${WORKSPACE}/vendor/qcom/opensource/agm/ipc/DBus/agm_server"

FILESPATH   =+ "${WORKSPACE}:"
SRC_URI     =  "file://vendor/qcom/opensource/agm/ipc/DBus/agm_server"

DEPENDS = "glib-2.0 libutils libcutils dbus agm"

S = "${WORKDIR}/vendor/qcom/opensource/agm/ipc/DBus/agm_server"

FILES_${PN}-dbg  = "${libdir}/.debug/*"
FILES_${PN}      = "${libdir}/*.so ${libdir}/*.so.* ${sysconfdir}/* ${libdir}/pkgconfig/* ${bindir}/* ${sbindir}/*"
FILES_${PN}-dev  = "${libdir}/*.la ${includedir}"
