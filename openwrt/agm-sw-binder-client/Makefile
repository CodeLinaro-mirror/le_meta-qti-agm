include $(TOPDIR)/rules.mk

PKG_NAME:=agm-sw-binder-client
PKG_RELEASE:=1
PKG_FIXUP:=autoreconf

LOCAL_SRC ?= $(TOPDIR)/src/vendor/qcom/opensource/agm/ipc/SwBinders/agm_client/

include $(INCLUDE_DIR)/package.mk

define Package/agm-sw-binder-client
  SECTION:=AUDIO
  CATEGORY:=AUDIO
  MAINTAINER:=QTI MM Audio
  TITLE:=AGM-SW-BINDER-CLIENT
  DEPENDS:= +libutils +libcutils +binder +glib2 +audio-utils +core-include +audio-log-utils +libexpat +agm-sw-binder-server
endef

define Package/agm-sw-binder-client/description
  AGM-SW-BINDER-CLIENT
endef

CONFIGURE_ARGS += \
	--without-cutils \
	--with-openwrt

TARGET_CFLAGS += \
	-DFEATURE_IPQ_OPENWRT \
	-I$(STAGING_DIR)/usr/include/ \
	-I$(STAGING_DIR)/usr/include/agm/ \
	-I$(STAGING_DIR)/usr/lib/ \
	-I$(STAGING_DIR)/usr/include/ar-osal \
	-I$(STAGING_DIR)/usr/include/agm-sw-binder-server \
	-I$(STAGING_DIR)/usr/include/audio-log-utils \
	-I $(STAGING_DIR)/usr/include/glib-2.0/

define Build/Prepare
	mkdir -p $(PKG_BUILD_DIR)/
	$(CP) $(LOCAL_SRC)/* $(PKG_BUILD_DIR)/
endef

define Build/InstallDev
	$(INSTALL_DIR) $(STAGING_DIR)
	mkdir -p $(1)/usr/include/agm-sw-binder-client/
	mkdir -p $(1)/usr/lib/
	$(CP) $(PKG_BUILD_DIR)/.libs/libagmclientwrapper.so* $(1)/usr/lib/
endef

define Package/agm-sw-binder-client/install
	$(INSTALL_DIR) $(1)/usr/lib
	$(CP) $(PKG_BUILD_DIR)/.libs/libagmclientwrapper.so* $(1)/usr/lib/
endef

$(eval $(call BuildPackage,agm-sw-binder-client))
