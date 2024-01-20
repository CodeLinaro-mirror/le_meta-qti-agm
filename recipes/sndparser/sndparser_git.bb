inherit autotools pkgconfig

DESCRIPTION = "sndparser"
SECTION = "multimedia"
LICENSE = "BSD-3-Clause-Clear"
LIC_FILES_CHKSUM = "file://${COREBASE}/meta-qti-bsp/files/common-licenses/\
${LICENSE};md5=3771d4920bd6cdb8cbdf1e8344489ee0"

FILESPATH =+ "${WORKSPACE}/:"
SRC_URI  = "file://vendor/qcom/opensource/agm/snd_parser"

S = "${WORKDIR}/vendor/qcom/opensource/agm/snd_parser"

PR = "r0"
DEPENDS = "agm"
EXTRA_OECONF += "--with-glib"
EXTRA_OECONF += " --with-basemachine=${BASEMACHINE}"
SOLIBS = ".so"
FILES_SOLIBSDEV = ""
