inherit autotools pkgconfig qprebuilt

DESCRIPTION = "agm localsocket front end Library"
SECTION = "multimedia"
LICENSE = "BSD-3-Clause-Clear"
LIC_FILES_CHKSUM = "file://${COREBASE}/meta/files/common-licenses/\
${LICENSE};md5=7a434440b651f4a472ca93716d01033a"

FILESPATH   =+ "${WORKSPACE}:"
SRC_DIR    =  "${WORKSPACE}/vendor/qcom/opensource/agm/ipc/LocalSocket/agm_ls_fe"
SRC_URI    =   "file://vendor/qcom/opensource/agm/ipc/LocalSocket/agm_ls_fe/"

S = "${WORKDIR}/vendor/qcom/opensource/agm/ipc/LocalSocket/agm_ls_fe/"
PR = "r0"
DEPENDS = "libutils libcutils liblog agm"

FILES:${PN}-dbg  = "${libdir}/.debug/*"
FILES:${PN}      = "${libdir}/*.so ${libdir}/*.so.* ${sysconfdir}/* ${libdir}/pkgconfig/*"
FILES:${PN}-dev  = "${libdir}/*.la ${includedir}"

EXTRA_OECONF += "--with-glib"
SOLIBS = ".so"
FILES_SOLIBSDEV = ""

