inherit autotools pkgconfig

DESCRIPTION = "agmtest"
SECTION = "multimedia"
LICENSE = "BSD-3-Clause & BSD-3-Clause-Clear"
LIC_FILES_CHKSUM = "file://${COREBASE}/meta/files/common-licenses/BSD-3-Clause;md5=550794465ba0ec5312d6919e203a55f9 \
                    file://${COREBASE}/meta/files/common-licenses/BSD-3-Clause-Clear;md5=7a434440b651f4a472ca93716d01033a"

FILESPATH =+ "${WORKSPACE}/:"
SRC_URI  = "file://vendor/qcom/opensource/agm/plugins/tinyalsa/test"

S = "${WORKDIR}/vendor/qcom/opensource/agm/plugins/tinyalsa/test"

do_install:append() {
       install -d ${D}${sysconfdir}
       install -m 0755 ${S}/*.xml ${D}${sysconfdir}/
}

PR = "r0"
DEPENDS = "tinycompress sndparser"

EXTRA_OECONF += "--with-glib"
EXTRA_OEMAKE += "DEFAULT_INCLUDES=-I${STAGING_KERNEL_BUILDDIR}/usr/include"

FILES:${PN}-dbg  = "${libdir}/.debug/*"
FILES:${PN}      = "${libdir}/*.so ${libdir}/*.so.* ${sysconfdir}/* ${libdir}/pkgconfig/* ${bindir}/* ${sbindir}/*"
FILES:${PN}-dev  = "${libdir}/*.la ${includedir}"
