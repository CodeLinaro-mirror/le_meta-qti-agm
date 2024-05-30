inherit autotools pkgconfig

DESCRIPTION = "sndparser"
SECTION = "multimedia"
LICENSE = "BSD"
LIC_FILES_CHKSUM = "file://${COREBASE}/meta/files/common-licenses/\
${LICENSE};md5=3775480a712fc46a69647678acb234cb"

FILESPATH =+ "${WORKSPACE}/:"
SRC_URI  = "file://vendor/qcom/opensource/agm/snd_parser"
SRC_URI += "file://${BASEMACHINE}/"

S = "${WORKDIR}/vendor/qcom/opensource/agm/snd_parser"

do_install_append() {
       install -d ${D}${sysconfdir}
       install -m 0664 ${WORKDIR}/${BASEMACHINE}/* ${D}${sysconfdir}/
}

PR = "r0"
DEPENDS = "libcutils expat glib-2.0 agm"
EXTRA_OECONF += "--with-glib"
SOLIBS = ".so"
FILES_SOLIBSDEV = ""
