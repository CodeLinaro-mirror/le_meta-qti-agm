include $(TOPDIR)/rules.mk

PKG_NAME:=sndparser
PKG_RELEASE:=1
PKG_FIXUP:=autoreconf

LOCAL_SRC ?= $(TOPDIR)/src/vendor/qcom/opensource/agm/snd_parser/

include $(INCLUDE_DIR)/package.mk

define Package/sndparser
  SECTION:=AUDIO
  CATEGORY:=AUDIO
  MAINTAINER:=QTI MM Audio
  TITLE:=SNDPARSER
  DEPENDS:= +glib2 +core-include
endef

define Package/sndparserdescription
  SNDPARSER
endef

CONFIGURE_ARGS += \
	--with-openwrt

TARGET_CFLAGS += \
	-DFEATURE_IPQ_OPENWRT \
	-I$(STAGING_DIR)/usr/include/ \
	-I$(STAGING_DIR)/usr/include/glib-2.0/ \
	-I$(STAGING_DIR)/usr/include/agm/

define Build/Prepare
	mkdir -p $(PKG_BUILD_DIR)/
	$(CP) $(LOCAL_SRC)/* $(PKG_BUILD_DIR)/
endef

define Build/InstallDev
	$(INSTALL_DIR) $(STAGING_DIR)
	mkdir -p $(1)/usr/include/sndparser/
	mkdir -p $(1)/usr/lib/
	$(CP) $(PKG_BUILD_DIR)/inc/*.h $(1)/usr/include/sndparser/
	$(CP) $(PKG_BUILD_DIR)/.libs/libsndcardparser.so* $(1)/usr/lib/
endef

define Package/sndparser/install
	$(INSTALL_DIR) $(1)/usr/lib
	$(CP) $(PKG_BUILD_DIR)/.libs/libsndcardparser.so* $(1)/usr/lib
endef

$(eval $(call BuildPackage,sndparser))
