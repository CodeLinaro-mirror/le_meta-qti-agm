include $(TOPDIR)/rules.mk

PKG_NAME:=agmplugin
PKG_RELEASE:=1
PKG_LICENSE:=BSD-3-Clause
PKG_FIXUP:=autoreconf

LOCAL_SRC ?= $(TOPDIR)/src/vendor/qcom/opensource/agm/plugins/tinyalsa/
include $(INCLUDE_DIR)/package.mk

define Package/agmplugin
  SECTION:=AUDIO
  CATEGORY:=AUDIO
  MAINTAINER:=QTI MM Audio
  TITLE:=AGMPLUGIN
  DEPENDS:= +tinyalsa +tinycompress +glib2 +agm +sndparser +audio-log-utils +agm-sw-binder-client
endef

define Package/agmplugin/description
  AGMPLUGIN
endef

CONFIGURE_ARGS += \
	--without-cutils \
	--with-openwrt


TARGET_CFLAGS += \
	-DFEATURE_IPQ_OPENWRT \
	-I$(STAGING_DIR)/usr/include/ \
	-I$(STAGING_DIR)/usr/include/agm/ \
	-I$(STAGING_DIR)/usr/include/glib-2.0/ \
	-I$(STAGING_DIR)/usr/include/ar-osal \
	-I$(STAGING_DIR)/usr/include/audio-log-utils \
	-I$(STAGING_DIR)/usr/include/acdbdata/ \
	-I$(STAGING_DIR)/usr/include/sndparser/

define Build/Prepare
	mkdir -p $(PKG_BUILD_DIR)/
	$(CP) $(LOCAL_SRC)/* $(PKG_BUILD_DIR)/
endef

define Build/InstallDev
	$(INSTALL_DIR) $(STAGING_DIR)
	mkdir -p $(1)/usr/lib/
	$(CP) $(PKG_BUILD_DIR)/.libs/*.so* $(1)/usr/lib/
endef

define Package/agmplugin/install
	$(INSTALL_DIR) $(1)/usr/lib
	$(CP) $(PKG_BUILD_DIR)/.libs/*.so* $(1)/usr/lib/
endef

$(eval $(call BuildPackage,agmplugin))
