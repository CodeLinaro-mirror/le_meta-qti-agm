inherit autotools pkgconfig

DESCRIPTION = "agm"
SECTION = "multimedia"
LICENSE = "BSD-Source-Code"
LIC_FILES_CHKSUM = "file://${COREBASE}/meta/files/common-licenses/\
${LICENSE};md5=fe8b41221d7524c70688f7d059ff6d87"

FILESPATH =+ "${WORKSPACE}/:"
SRC_URI  = "file://vendor/qcom/opensource/agm/service/"

S = "${WORKDIR}/vendor/qcom/opensource/agm/service/"
PR = "r0"

DEPENDS = "tinyalsa ats acdbdata audio-log-utils mm-audio-headers"

EXTRA_OECONF += "--with-glib"
SOLIBS = ".so"
FILES_SOLIBSDEV = ""
