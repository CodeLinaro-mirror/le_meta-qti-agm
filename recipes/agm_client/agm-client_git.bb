inherit autotools pkgconfig

DESCRIPTION = "agm client"
SECTION = "multimedia"
LICENSE = "BSD-3-Clause"
LIC_FILES_CHKSUM = "file://${COREBASE}/meta/files/common-licenses/\
${LICENSE};md5=550794465ba0ec5312d6919e203a55f9"

FILESPATH   =+ "${WORKSPACE}/:"
SRC_URI    =   "file://vendor/qcom/opensource/agm/ipc/DBus/agm_client"

S = "${WORKDIR}/vendor/qcom/opensource/agm/ipc/DBus/agm_client"
PR = "r0"

DEPENDS = "glib-2.0 libutils libcutils binder agm-server liblog"

EXTRA_OECONF += "--with-glib"
SOLIBS = ".so"
FILES_SOLIBSDEV = ""

FILES:${PN}-dbg  = "${libdir}/.debug/*"
FILES:${PN}      = "${libdir}/*.so ${libdir}/*.so.* ${sysconfdir}/* ${libdir}/pkgconfig/*"
FILES:${PN}-dev  = "${libdir}/*.la ${includedir}"

RM_WORK_EXCLUDE += "${PN}"
