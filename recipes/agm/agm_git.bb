SUMMARY = "AGM for AROSP"
LICENSE = "BSD-3-Clause"
LIC_FILES_CHKSUM = "file://${COREBASE}/meta/files/common-licenses/${LICENSE};md5=550794465ba0ec5312d6919e203a55f9"

FILESPATH =+ "${WORKSPACE}/:"
SRC_URI = "file://vendor/qcom/opensource/agm/ \
           file://0001-service-device-Add-support-of-new-channel-map.patch"
S = "${WORKDIR}/vendor/qcom/opensource/agm"
DEPENDS = "glib-2.0 tinyalsa tinycompress args mm-audio-headers expat"
EXTRA_OECONF += "--with-glib --without-syslog"
EXTRA_OECONF += "--with-basemachine=${BASEMACHINE}"
SOLIBS = ".so"
FILES_SOLIBSDEV = ""

inherit autotools pkgconfig
