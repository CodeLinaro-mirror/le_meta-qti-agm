inherit autotools pkgconfig

DESCRIPTION = "sndparser"
SECTION = "multimedia"
LICENSE = "BSD-3-Clause"
LIC_FILES_CHKSUM = "file://${COREBASE}/meta/files/common-licenses/\
${LICENSE};md5=550794465ba0ec5312d6919e203a55f9"

FILESPATH =+ "${WORKSPACE}/:"
SRC_URI  = "file://vendor/qcom/opensource/agm/snd_parser"

S = "${WORKDIR}/vendor/qcom/opensource/agm/snd_parser"

PR = "r0"
DEPENDS = "agm"
EXTRA_OECONF += "--with-glib"
EXTRA_OECONF += "--with-basemachine=${BASEMACHINE}"
SOLIBS = ".so"
FILES_SOLIBSDEV = ""
