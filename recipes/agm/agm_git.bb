inherit autotools pkgconfig

DESCRIPTION = "agm"
SECTION = "multimedia"
LICENSE = "BSD-3-Clause & BSD-3-Clause-Clear"
LIC_FILES_CHKSUM = "file://${COREBASE}/meta/files/common-licenses/BSD-3-Clause;md5=550794465ba0ec5312d6919e203a55f9 \
                    file://${COREBASE}/meta/files/common-licenses/BSD-3-Clause-Clear;md5=7a434440b651f4a472ca93716d01033a"

FILESPATH =+ "${WORKSPACE}/:"
SRC_URI  = "file://vendor/qcom/opensource/agm/service"

S = "${WORKDIR}/vendor/qcom/opensource/agm/service"
PR = "r0"

DEPENDS = "glib-2.0 tinyalsa ats acdbdata spf mm-audio-headers expat audio-log-utils"
RM_WORK_EXCLUDE += "${PN}"

TARGET_CFLAGS += "-I${STAGING_INCDIR}/spf"

EXTRA_OECONF += "--with-glib"
SOLIBS = ".so"
FILES_SOLIBSDEV = ""
