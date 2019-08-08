include $(TOPDIR)/rules.mk

PKG_NAME:=agm-unit-test
PKG_RELEASE:=1
PKG_FIXUP:=autoreconf

LOCAL_SRC:=$(TOPDIR)/qca/src/vendor/qcom/opensource/audio-graph-mgr/service/test
include $(INCLUDE_DIR)/local-development.mk
ifeq ($(DUMP)$(PKG_VERSION),)
  PKG_REV:=$(shell git ls-remote $(PKG_SOURCE_URL) $(PKG_BRANCH) | cut -b -7)
  PKG_VERSION:=g$(PKG_REV)
endif

include $(INCLUDE_DIR)/package.mk

define Package/agm-unit-test
  SECTION:=AUDIO
  CATEGORY:=AUDIO
  DEPENDS:= +agm +agm-client
  MAINTAINER:=QTI MM Audio
  TITLE:=AGM-UNIT-TEST
  SUBMENU:=CASA
endef

define Package/agm-unit-test/description
  This package contails agm-unit-test
endef

CONFIGURE_ARGS += \
                  --with-openwrt

TARGET_CFLAGS += \
                 -I$(STAGING_DIR)/usr/include/agm/

TARGET_LDFLAGS += \
                 -L$(STAGING_DIR)/usr/lib/

define Package/agm-unit-test/install
	$(INSTALL_DIR) $(1)/usr/bin
	$(INSTALL_BIN) $(PKG_BUILD_DIR)/agm_ipc_test $(1)/usr/bin
	$(INSTALL_BIN) $(PKG_BUILD_DIR)/agmtest $(1)/usr/bin
endef

$(eval $(call BuildPackage,agm-unit-test))
