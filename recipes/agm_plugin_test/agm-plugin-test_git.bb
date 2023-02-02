inherit autotools pkgconfig

DESCRIPTION = "agmtest"
SECTION = "multimedia"
LICENSE = "BSD-Source-Code"
LIC_FILES_CHKSUM = "file://${COREBASE}/meta/files/common-licenses/\
${LICENSE};md5=fe8b41221d7524c70688f7d059ff6d87"

FILESPATH =+ "${WORKSPACE}/:"
SRC_URI  = "file://vendor/qcom/opensource/agm/plugins/tinyalsa/test/"

S = "${WORKDIR}/vendor/qcom/opensource/agm/plugins/tinyalsa/test/"

PR = "r0"
DEPENDS = "tinycompress sndparser"

EXTRA_OECONF += "--with-glib"

FILES:${PN}-dbg  = "${libdir}/.debug/*"
FILES:${PN}      = "${libdir}/*.so ${libdir}/*.so.* ${sysconfdir}/* ${libdir}/pkgconfig/* ${bindir}/* ${sbindir}/*"
FILES:${PN}-dev  = "${libdir}/*.la ${includedir}"
