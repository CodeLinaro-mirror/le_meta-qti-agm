inherit autotools pkgconfig

DESCRIPTION = "agm sw binder client"
SECTION = "multimedia"
LICENSE = "BSD-3-Clause-Clear"
LIC_FILES_CHKSUM = "file://${COREBASE}/meta/files/common-licenses/BSD;md5=3775480a712fc46a69647678acb234cb"

PR = "r0"

SRC_DIR    =  "${WORKSPACE}/vendor/qcom/opensource/agm/ipc/SwBinders/agm_client"

FILESPATH   =+ "${WORKSPACE}:"
SRC_URI    =   "file://vendor/qcom/opensource/agm/ipc/SwBinders/agm_client/"

DEPENDS = "glib-2.0 libutils libcutils binder agm-sw-binder-server liblog audio-log-utils ar-osal"

EXTRA_OECONF += "--with-glib"
SOLIBS = ".so"
FILES_SOLIBSDEV = ""

S = "${WORKDIR}/vendor/qcom/opensource/agm/ipc/SwBinders/agm_client/"
FILES_${PN}-dbg  = "${libdir}/.debug/*"
FILES_${PN}      = "${libdir}/*.so ${libdir}/*.so.* ${sysconfdir}/* ${libdir}/pkgconfig/* ${bindir}/* ${sbindir}/*"
FILES_${PN}-dev  = "${libdir}/*.la ${includedir}"

RM_WORK_EXCLUDE += "${PN}"
