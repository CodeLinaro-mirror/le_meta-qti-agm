inherit autotools pkgconfig qprebuilt

DESCRIPTION = "agm test binaries"
SECTION = "multimedia"
LICENSE = "BSD"
LIC_FILES_CHKSUM = "file://${COREBASE}/meta/files/common-licenses/\
${LICENSE};md5=3775480a712fc46a69647678acb234cb"

PR = "r0"

SRC_DIR     =  "${WORKSPACE}/vendor/qcom/opensource/agm/service/test"

FILESPATH   =+ "${WORKSPACE}:"
SRC_URI     =  "file://vendor/qcom/opensource/agm/service/test"

DEPENDS = "agm agm-client"

S = "${WORKDIR}/vendor/qcom/opensource/agm/service/test"

PACKAGECONFIG += "${@bb.utils.contains('MACHINE_FEATURES', 'dlt-logging', 'dlt_logging_enabled', '', d)}"
PACKAGECONFIG[dlt_logging_enabled] = "--with-dltlogging,--without-dltlogging,dlt-daemon"

FILES:${PN}-dbg  = "${libdir}/.debug/*"
FILES:${PN}      = "${libdir}/*.so ${libdir}/*.so.* ${sysconfdir}/* ${libdir}/pkgconfig/* ${bindir}/* ${sbindir}/*"
FILES:${PN}-dev  = "${libdir}/*.la ${includedir}"
