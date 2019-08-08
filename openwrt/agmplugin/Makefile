include $(TOPDIR)/rules.mk

PKG_NAME:=agmplugin
PKG_RELEASE:=1
PKG_FIXUP:=autoreconf

LOCAL_SRC:=$(TOPDIR)/qca/src/vendor/qcom/opensource/audio-graph-mgr/plugins/tinyalsa
include $(INCLUDE_DIR)/local-development.mk
ifeq ($(DUMP)$(PKG_VERSION),)
  PKG_REV:=$(shell git ls-remote $(PKG_SOURCE_URL) $(PKG_BRANCH) | cut -b -7)
  PKG_VERSION:=g$(PKG_REV)
endif

include $(INCLUDE_DIR)/package.mk

define Package/agmplugin
  SECTION:=AUDIO
  CATEGORY:=AUDIO
  DEPENDS:= +tinyalsa +agm +sndparser
  MAINTAINER:=QTI MM Audio
  TITLE:=AGMPLUGIN
  SUBMENU:=CASA
endef

define Package/agmplugin/description
  This package contails agmplugin
endef

CONFIGURE_ARGS += \
                  --with-openwrt

TARGET_CFLAGS += \
                 -I$(STAGING_DIR)/usr/include/agm/ \
                 -I$(STAGING_DIR)/usr/include/sndparser/ \
                 -I$(STAGING_DIR)/usr/include/osal/ \
                 -DFEATURE_IPQ_OPENWRT

TARGET_LDFLAGS += \
                 -L$(STAGING_DIR)/usr/lib/

define Build/InstallDev
	$(INSTALL_DIR) $(1)/usr/lib/
	$(CP) $(PKG_BUILD_DIR)/.libs/libagm_pcm_plugin.so $(1)/usr/lib/
	$(CP) $(PKG_BUILD_DIR)/.libs/libagm_mixer_plugin.so $(1)/usr/lib/
endef

define Package/agmplugin/install
	$(INSTALL_DIR) $(1)/usr/lib
	$(INSTALL_BIN) $(PKG_BUILD_DIR)/.libs/libagm_pcm_plugin.so $(1)/usr/lib
	$(INSTALL_BIN) $(PKG_BUILD_DIR)/.libs/libagm_mixer_plugin.so $(1)/usr/lib
endef

$(eval $(call BuildPackage,agmplugin))
