inherit autotools pkgconfig

DESCRIPTION = "agm"
SECTION = "multimedia"
LICENSE = "BSD-3-Clause & BSD-3-Clause-Clear"
LIC_FILES_CHKSUM = "file://${COREBASE}/meta/files/common-licenses/BSD-3-Clause;md5=550794465ba0ec5312d6919e203a55f9 \
                    file://${COREBASE}/meta/files/common-licenses/BSD-3-Clause-Clear;md5=7a434440b651f4a472ca93716d01033a"

FILESPATH =+ "${WORKSPACE}/:"
SRC_URI  = "file://vendor/qcom/opensource/agm"

S = "${WORKDIR}/vendor/qcom/opensource/agm"
PR = "r0"

DEPENDS = "glib-2.0 tinycompress tinyalsa ats acdbdata spf mm-audio-headers expat audio-log-utils"

TARGET_CFLAGS += "-I${STAGING_INCDIR}/spf"

EXTRA_OECONF += "--with-glib"
EXTRA_OECONF += "--without-syslog --with-agm-no-ipc"
EXTRA_OECONF += "${@'--with-32bit=yes' if d.getVar('PN').startswith('lib32-') else '--with-32bit=no'}"
SOLIBS = ".so"
FILES_SOLIBSDEV = ""
