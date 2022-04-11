inherit autotools pkgconfig

DESCRIPTION = "agm client"
SECTION = "multimedia"
LICENSE = "BSD"
LIC_FILES_CHKSUM = "file://${COREBASE}/meta/files/common-licenses/\
${LICENSE};md5=3775480a712fc46a69647678acb234cb"

FILESPATH   =+ "${WORKSPACE}/:"
SRC_URI    =   "file://vendor/qcom/opensource/agm/ipc/DBus/agm_client"

S = "${WORKDIR}/vendor/qcom/opensource/agm/ipc/DBus/agm_client"
PR = "r0"

DEPENDS = "glib-2.0 libutils libcutils binder agm-server liblog"

EXTRA_OECONF += "--with-glib"
SOLIBS = ".so"
FILES_SOLIBSDEV = ""

FILES_${PN}-dbg  = "${libdir}/.debug/*"
FILES_${PN}      = "${libdir}/*.so ${libdir}/*.so.* ${sysconfdir}/* ${libdir}/pkgconfig/*"
FILES_${PN}-dev  = "${libdir}/*.la ${includedir}"

RM_WORK_EXCLUDE += "${PN}"
