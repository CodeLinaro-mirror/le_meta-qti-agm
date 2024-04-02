#SUMMARY = "QTI Audio Package Group"

LICENSE = "BSD-3-Clause"

RDEPENDS_packagegroup-qti-audio += ' \
    agmplugin \
    agm-plugin-test \
    agm \
    ${@bb.utils.contains('BASEMACHINE', 'sdxlemur', 'agm-sw-binder-client', '', d)} \
    ${@bb.utils.contains('BASEMACHINE', 'sdxlemur', 'agm-sw-binder-server', '', d)} \
    ${@bb.utils.contains('BASEMACHINE', 'sa525m"', 'agm-sw-binder-client', '',  d)} \
    ${@bb.utils.contains('BASEMACHINE', 'sa525m', 'agm-sw-binder-server', '', d)} \
'
