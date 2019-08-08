include $(TOPDIR)/rules.mk

PKG_NAME:=agm_client
PKG_RELEASE:=1
PKG_FIXUP:=autoreconf

LOCAL_SRC:=$(TOPDIR)/qca/src/vendor/qcom/opensource/audio-graph-mgr/ipc/agm_client/
include $(INCLUDE_DIR)/local-development.mk
ifeq ($(DUMP)$(PKG_VERSION),)
  PKG_REV:=$(shell git ls-remote $(PKG_SOURCE_URL) $(PKG_BRANCH) | cut -b -7)
  PKG_VERSION:=g$(PKG_REV)
endif

include $(INCLUDE_DIR)/package.mk

define Package/agm_client
  SECTION:=AUDIO
  CATEGORY:=AUDIO
  DEPENDS:= +agm_server +glib2 +osal
  MAINTAINER:=QTI MM Audio
  TITLE:=AGM-CLIENT
  SUBMENU:=CASA
endef

define Package/agm_client/description
  This package contails agm_client
endef

CONFIGURE_ARGS += \
                  --with-openwrt \
                  --with-glib

TARGET_CFLAGS += \
                 -I$(STAGING_DIR)/usr/include/agm/ \
                 -I$(STAGING_DIR)/usr/include/glib-2.0/ \
                 -I$(STAGING_DIR)/usr/include/osal/

TARGET_LDFLAGS += \
                 -L$(STAGING_DIR)/usr/lib/

define Build/InstallDev
	$(INSTALL_DIR) $(1)/usr/lib/
	$(CP) $(PKG_BUILD_DIR)/.libs/libagmclient.so $(1)/usr/lib/
endef

define Package/agm_client/install
	$(INSTALL_DIR) $(1)/usr/lib
	$(INSTALL_BIN) $(PKG_BUILD_DIR)/.libs/libagmclient.so $(1)/usr/lib
endef

$(eval $(call BuildPackage,agm_client))
