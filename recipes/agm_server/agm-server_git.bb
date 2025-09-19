inherit autotools pkgconfig qprebuilt systemd

DESCRIPTION = "agm services Library"
SECTION = "multimedia"
LICENSE = "BSD-3-Clause"
LIC_FILES_CHKSUM = "file://${COREBASE}/meta/files/common-licenses/\
${LICENSE};md5=550794465ba0ec5312d6919e203a55f9"

PR = "r0"

SRC_DIR     =  "${WORKSPACE}/vendor/qcom/opensource/agm/ipc/SwBinders/agm_server"

FILESPATH   =+ "${WORKSPACE}:"
SRC_URI     =  "file://vendor/qcom/opensource/agm/ipc/SwBinders/agm_server \
                file://agm_server.service \
                "

SYSTEMD_SERVICE:${PN} = "agm_server.service"

DEPENDS = "libutils libcutils binder agm"

S = "${WORKDIR}/vendor/qcom/opensource/agm/ipc/SwBinders/agm_server"

FILES_${PN}-dbg  = "${libdir}/.debug/*"
FILES_${PN}      = "${libdir}/*.so ${libdir}/*.so.* ${sysconfdir}/* ${libdir}/pkgconfig/* ${bindir}/* ${sbindir}/*"
FILES_${PN}-dev  = "${libdir}/*.la ${includedir}"

SOLIBS = ".so"
FILES_SOLIBSDEV = ""


do_install:append() {
	install -d ${D}${systemd_system_unitdir}
	install -m 0644 ${WORKDIR}/agm_server.service ${D}${systemd_system_unitdir}
	install -d ${D}${systemd_system_unitdir}/multi-user.target.wants/
	ln -sf ${systemd_system_unitdir}/agm_server.service \
	       ${D}${systemd_system_unitdir}/multi-user.target.wants/agm_server.service
}

FILES:${PN} += "${libdir}/*.so \
                ${libdir}/*.so.* \
                ${sysconfdir}/* \
                ${libdir}/pkgconfig/* \
                ${bindir}/* \
                ${sbindir}/* \
                ${systemd_system_unitdir}/agm_server.service \
                ${systemd_system_unitdir}/multi-user.target.wants/agm_server.service \
                "