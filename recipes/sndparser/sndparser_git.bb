inherit autotools pkgconfig

DESCRIPTION = "sndparser"
SECTION = "multimedia"
LICENSE = "BSD-Source-Code"
LIC_FILES_CHKSUM = "file://${COREBASE}/meta/files/common-licenses/\
${LICENSE};md5=fe8b41221d7524c70688f7d059ff6d87"

FILESPATH =+ "${WORKSPACE}/:"
SRC_URI  = "file://vendor/qcom/opensource/agm/snd_parser/"

S = "${WORKDIR}/vendor/qcom/opensource/agm/snd_parser/"

PR = "r0"
DEPENDS = "agm"
EXTRA_OECONF += "--with-glib"
EXTRA_OECONF += " --with-basemachine=${BASEMACHINE}"
SOLIBS = ".so"
FILES_SOLIBSDEV = ""
