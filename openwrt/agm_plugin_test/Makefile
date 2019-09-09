include $(TOPDIR)/rules.mk

PKG_NAME:=agm_plugin_test
PKG_RELEASE:=1
PKG_FIXUP:=autoreconf

LOCAL_SRC:=$(TOPDIR)/qca/src/vendor/qcom/opensource/audio-graph-mgr/plugins/tinyalsa/test
include $(INCLUDE_DIR)/local-development.mk
ifeq ($(DUMP)$(PKG_VERSION),)
  PKG_REV:=$(shell git ls-remote $(PKG_SOURCE_URL) $(PKG_BRANCH) | cut -b -7)
  PKG_VERSION:=g$(PKG_REV)
endif

include $(INCLUDE_DIR)/package.mk

define Package/agm_plugin_test
  SECTION:=AUDIO
  CATEGORY:=AUDIO
  DEPENDS:= +glib2 +tinyalsa +agm +acdbdata
  MAINTAINER:=QTI MM Audio
  TITLE:=AGM-PLUGIN-TEST
  SUBMENU:=CASA
endef

define Package/agm_plugin_test/description
  This package contails agm plugin test app.
endef

CONFIGURE_ARGS += \
                  --with-openwrt \
                  --with-glib

TARGET_CFLAGS += \
                 -I$(STAGING_DIR)/usr/include/glib-2.0/ \
                 -I$(STAGING_DIR)/usr/include/agm/ \
                 -I$(STAGING_DIR)/usr/include/acdbdata/ \
                 -I$(STAGING_DIR)/usr/lib/dbus-1.0/include/ \
                 -I$(STAGING_DIR)/usr/include/dbus-1.0/ \
                 -I$(STAGING_DIR)/usr/include/glib-2.0/ \
                 -I$(STAGING_DIR)/usr/include/
#                 -DFEATURE_IPQ_OPENWRT

TARGET_LDFLAGS += \
                 -L$(STAGING_DIR)/usr/lib/

define Build/InstallDev
	$(INSTALL_DIR) $(1)/usr/lib/
	$(INSTALL_DIR) $(1)/usr/bin/
	$(CP) $(PKG_BUILD_DIR)/.libs/libagmmixer.so $(1)/usr/lib/
	$(CP) $(PKG_BUILD_DIR)/.libs/agmplay $(1)/usr/bin/
	$(CP) $(PKG_BUILD_DIR)/.libs/agmcap $(1)/usr/bin/
	$(CP) $(PKG_BUILD_DIR)/.libs/agmhostless $(1)/usr/bin/
	$(CP) $(PKG_BUILD_DIR)/.libs/agmvoiceui $(1)/usr/bin/
endef

define Package/agm_plugin_test/install
	$(INSTALL_DIR) $(1)/usr/lib
	$(INSTALL_DIR) $(1)/usr/bin/
	$(INSTALL_DIR) $(1)/etc/init.d
	$(INSTALL_BIN) $(PKG_BUILD_DIR)/.libs/libagmmixer.so $(1)/usr/lib
	$(INSTALL_BIN) $(PKG_BUILD_DIR)/.libs/agmplay $(1)/usr/bin/
	$(INSTALL_BIN) $(PKG_BUILD_DIR)/.libs/agmcap $(1)/usr/bin/
	$(INSTALL_BIN) $(PKG_BUILD_DIR)/.libs/agmhostless $(1)/usr/bin/
	$(INSTALL_BIN) $(PKG_BUILD_DIR)/.libs/agmvoiceui $(1)/usr/bin/
endef

$(eval $(call BuildPackage,agm_plugin_test))
