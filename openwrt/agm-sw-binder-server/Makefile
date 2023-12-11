include $(TOPDIR)/rules.mk

PKG_NAME:=agm-sw-binder-server
PKG_RELEASE:=1
PKG_FIXUP:=autoreconf

LOCAL_SRC ?= $(TOPDIR)/src/vendor/qcom/opensource/agm/ipc/SwBinders/agm_server/

include $(INCLUDE_DIR)/package.mk

define Package/agm-sw-binder-server
  SECTION:=AUDIO
  CATEGORY:=AUDIO
  MAINTAINER:=QTI MM Audio
  TITLE:=AGM-SW-BINDER-SERVER
  DEPENDS:= +libutils +libcutils +binder +agm +glib2 +audio-utils +core-include +audio-log-utils
endef

define Package/agm-sw-binder-server/description
  AGM-SW-BINDER-SERVER
endef

CONFIGURE_ARGS += \
	--without-cutils \
	--with-openwrt

TARGET_CFLAGS += \
	-DFEATURE_IPQ_OPENWRT \
	-I$(STAGING_DIR)/usr/include/ \
	-I$(STAGING_DIR)/usr/include/agm/ \
	-I$(STAGING_DIR)/usr/include/ar-osal \
	-I$(STAGING_DIR)/usr/include/audio-log-utils \
	-I $(STAGING_DIR)/usr/include/glib-2.0/

define Build/Prepare
	mkdir -p $(PKG_BUILD_DIR)/
	$(CP) $(LOCAL_SRC)/* $(PKG_BUILD_DIR)/
endef

define Build/InstallDev
	$(INSTALL_DIR) $(STAGING_DIR)
	mkdir -p $(1)/usr/include/agm-sw-binder-server/
	mkdir -p $(1)/usr/lib/
	mkdir -p $(1)/usr/bin
	$(CP) $(PKG_BUILD_DIR)/inc/*.h $(1)/usr/include/agm-sw-binder-server/
	$(CP) $(PKG_BUILD_DIR)/.libs/libagmserverwrapper.so* $(1)/usr/lib/
	$(CP) $(PKG_BUILD_DIR)/.libs/libagmproxy.so* $(1)/usr/lib/
	$(INSTALL_BIN) $(PKG_BUILD_DIR)/.libs/agm_server $(1)/usr/bin/
endef

define Package/agm-sw-binder-server/install
	$(INSTALL_DIR) $(1)/usr/lib
	$(INSTALL_DIR) $(1)/etc/init.d
	$(INSTALL_DIR) $(1)/usr/bin/
	$(INSTALL_DIR) $(1)/etc/capabilities
	$(CP) $(PKG_BUILD_DIR)/.libs/libagmserverwrapper.so* $(1)/usr/lib/
	$(CP) $(PKG_BUILD_DIR)/.libs/libagmproxy.so* $(1)/usr/lib/
	$(INSTALL_BIN) $(PKG_BUILD_DIR)/.libs/agm_server $(1)/usr/bin/
	$(INSTALL_BIN) ./files/agm_server.init $(1)/etc/init.d/
	$(INSTALL_DATA) ./files/agm_server.json $(1)/etc/capabilities
endef

$(eval $(call BuildPackage,agm-sw-binder-server))
