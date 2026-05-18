inherit autotools pkgconfig qprebuilt

DESCRIPTION = "agm services Library"
SECTION = "multimedia"
LICENSE = "BSD-3-Clause"
LIC_FILES_CHKSUM = "file://${COREBASE}/meta/files/common-licenses/\
${LICENSE};md5=550794465ba0ec5312d6919e203a55f9"

PR = "r0"

SRC_DIR    =  "${WORKSPACE}/vendor/qcom/opensource/agm/ipc/agm_client"

FILESPATH   =+ "${WORKSPACE}:"
SRC_URI    =   "file://vendor/qcom/opensource/agm/ipc/agm_client/"

DEPENDS = "libutils libcutils binder agm-server liblog"

S = "${WORKDIR}/vendor/qcom/opensource/agm/ipc/agm_client/"

FILES:${PN}-dbg  = "${libdir}/.debug/*"
FILES:${PN}      = "${libdir}/*.so ${libdir}/*.so.* ${sysconfdir}/* ${libdir}/pkgconfig/*"
FILES:${PN}-dev  = "${libdir}/*.la ${includedir}"

