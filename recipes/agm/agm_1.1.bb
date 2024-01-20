inherit autotools pkgconfig

DESCRIPTION = "agm"
SECTION = "multimedia"
LICENSE = "BSD-3-Clause-Clear"
LIC_FILES_CHKSUM = "file://${COREBASE}/meta-qti-bsp/files/common-licenses/\
${LICENSE};md5=3771d4920bd6cdb8cbdf1e8344489ee0"

FILESPATH =+ "${WORKSPACE}/:"
SRC_URI  = "file://vendor/qcom/opensource/agm/service"

S = "${WORKDIR}/vendor/qcom/opensource/agm/service"
PR = "r0"

DEPENDS = "tinyalsa ats acdbdata audio-log-utils"

EXTRA_OECONF += "--with-glib"
SOLIBS = ".so"
FILES_SOLIBSDEV = ""
