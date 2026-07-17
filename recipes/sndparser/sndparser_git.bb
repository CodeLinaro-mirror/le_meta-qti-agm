inherit autotools pkgconfig

DESCRIPTION = "sndparser"
SECTION = "multimedia"
LICENSE = "BSD-3-Clause"
LIC_FILES_CHKSUM = "file://${COREBASE}/meta/files/common-licenses/\
${LICENSE};md5=550794465ba0ec5312d6919e203a55f9"

FILESPATH =+ "${WORKSPACE}/:"
SRC_URI  = "file://vendor/qcom/opensource/agm/snd_parser"
SRC_URI += "file://${BASEMACHINE}/"

S = "${WORKDIR}/vendor/qcom/opensource/agm/snd_parser"

do_install:append() {
       install -d ${D}${sysconfdir}
       install -m 0664 ${WORKDIR}/${BASEMACHINE}/* ${D}${sysconfdir}/
}

PACKAGECONFIG += "${@bb.utils.contains('MACHINE_FEATURES', 'dlt-logging', 'dlt_logging_enabled', '', d)}"
PACKAGECONFIG[dlt_logging_enabled] = "--with-dltlogging,,dlt-daemon"

PR = "r0"
DEPENDS = "libcutils expat glib-2.0 agm"
EXTRA_OECONF += "--with-glib"
SOLIBS = ".so"
FILES_SOLIBSDEV = ""
