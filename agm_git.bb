SUMMARY = "AGM for AROSP"
LICENSE = "BSD-3-Clause"
LIC_FILES_CHKSUM += "file://service/src/agm.c;beginline=30;endline=31;md5=0f37b80cb1f8d808a27cca9f0cb5e0ac \
                     file://service/inc/public/agm/agm_api.h;beginline=31;endline=32;md5=2eeb25220b858bebc66a98390f40229e"

FILESPATH =+ "${WORKSPACE}/:"
SRC_URI = "file://audio/opensource/agm/ \
           file://0001-service-device-Add-support-of-new-channel-map.patch"
S = "${WORKDIR}/audio/opensource/agm/"
DEPENDS = "glib-2.0 tinyalsa args mm-audio-headers expat"
EXTRA_OECONF += "--with-glib --with-syslog --with-agm-no-ipc"
SOLIBS = ".so"
FILES_SOLIBSDEV = ""

RM_WORK_EXCLUDE += "${PN}"

inherit autotools pkgconfig
