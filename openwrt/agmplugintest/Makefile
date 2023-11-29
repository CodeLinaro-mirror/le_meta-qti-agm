include $(TOPDIR)/rules.mk

PKG_NAME:=agmplugintest
PKG_RELEASE:=1
PKG_FIXUP:=autoreconf

LOCAL_SRC ?= $(TOPDIR)/src/vendor/qcom/opensource/agm/plugins/tinyalsa/test
include $(INCLUDE_DIR)/package.mk

define Package/agmplugintest
  SECTION:=AUDIO
  CATEGORY:=AUDIO
  MAINTAINER:=QTI MM Audio
  TITLE:=AGMPLUGINTEST
  DEPENDS:= +tinyalsa +tinycompress +agm +capiv2-headers
endef

define Package/agmplugintest/description
  AGMPLUGINTEST
endef

CONFIGURE_ARGS += \
	--without-cutils \
	--with-openwrt


TARGET_CFLAGS += \
	-DFEATURE_IPQ_OPENWRT \
	-I$(STAGING_DIR)/usr/include/ \
	-I$(STAGING_DIR)/usr/include/agm/ \
	-I$(STAGING_DIR)/usr/include/glib-2.0/ \
	-I$(STAGING_DIR)/usr/include/acdbdata/ \
	-I$(STAGING_DIR)/usr/include/capiv2_headers/

define Build/Prepare
	mkdir -p $(PKG_BUILD_DIR)/
	$(CP) $(LOCAL_SRC)/* $(PKG_BUILD_DIR)/
endef

define Build/InstallDev
	$(INSTALL_DIR) $(STAGING_DIR)
	mkdir -p $(1)/usr/lib/
	mkdir -p $(1)/usr/bin
	$(CP) $(PKG_BUILD_DIR)/.libs/libagmmixer.so* $(1)/usr/lib/
	$(CP) $(PKG_BUILD_DIR)/.libs/agmcap $(1)/usr/bin/
	$(CP) $(PKG_BUILD_DIR)/.libs/agmhostless $(1)/usr/bin/
	$(CP) $(PKG_BUILD_DIR)/.libs/agmplay $(1)/usr/bin/
	$(CP) $(PKG_BUILD_DIR)/.libs/agmvoiceui $(1)/usr/bin/
endef

define Package/agmplugintest/install
	$(INSTALL_DIR) $(1)/usr/lib
	mkdir -p $(1)/usr/bin
	$(CP) $(PKG_BUILD_DIR)/.libs/libagmmixer.so* $(1)/usr/lib/
	$(INSTALL_BIN) $(PKG_BUILD_DIR)/.libs/agmcap $(1)/usr/bin/
	$(INSTALL_BIN) $(PKG_BUILD_DIR)/.libs/agmhostless $(1)/usr/bin/
	$(INSTALL_BIN) $(PKG_BUILD_DIR)/.libs/agmplay $(1)/usr/bin/
	$(INSTALL_BIN) $(PKG_BUILD_DIR)/.libs/agmvoiceui $(1)/usr/bin/
endef

$(eval $(call BuildPackage,agmplugintest))
