inherit autotools pkgconfig

DESCRIPTION = "agm sw binder client"
SECTION = "multimedia"
LICENSE = "BSD-3-Clause"
LIC_FILES_CHKSUM = "file://${COREBASE}/meta/files/common-licenses/\
${LICENSE};md5=550794465ba0ec5312d6919e203a55f9"

PR = "r0"

SRC_DIR    =  "${WORKSPACE}/vendor/qcom/opensource/agm/ipc/SwBinders/agm_client"

FILESPATH   =+ "${WORKSPACE}:"
SRC_URI    =   "file://vendor/qcom/opensource/agm/ipc/SwBinders/agm_client/"

DEPENDS = "glib-2.0 libutils libcutils binder agm-sw-binder-server liblog audio-log-utils ar-osal"

EXTRA_OECONF += "--with-glib"
SOLIBS = ".so"
FILES_SOLIBSDEV = ""

S = "${WORKDIR}/vendor/qcom/opensource/agm/ipc/SwBinders/agm_client/"
FILES:${PN}-dbg  = "${libdir}/.debug/*"
FILES:${PN}      = "${libdir}/*.so ${libdir}/*.so.* ${sysconfdir}/* ${libdir}/pkgconfig/* ${bindir}/* ${sbindir}/*"
FILES:${PN}-dev  = "${libdir}/*.la ${includedir}"

RM_WORK_EXCLUDE += "${PN}"
