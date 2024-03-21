include $(TOPDIR)/rules.mk

PKG_NAME:=agm
PKG_RELEASE:=1
PKG_LICENSE:=BSD-3-Clause
PKG_FIXUP:=autoreconf

LOCAL_SRC ?= $(TOPDIR)/src/vendor/qcom/opensource/agm/service/

include $(INCLUDE_DIR)/package.mk

define Package/agm
  SECTION:=AUDIO
  CATEGORY:=AUDIO
  MAINTAINER:=QTI MM Audio
  TITLE:=AGM
  DEPENDS:= +tinyalsa +glib2 +ar-gsl +acdbdata +acdb +ats +audio-utils +core-include +audio-log-utils
endef

define Package/agm/description
  AGM
endef

CONFIGURE_ARGS += \
	--without-cutils \
	--with-openwrt

TARGET_CFLAGS += \
	-DFEATURE_IPQ_OPENWRT \
	-I$(STAGING_DIR)/usr/include/spf/api/modules/ \
	-I$(STAGING_DIR)/usr/include/spf/api/apm/ \
	-I$(STAGING_DIR)/usr/include/spf/api/ar_utils/ \
	-I$(STAGING_DIR)/usr/include/spf/api/vcpm/ \
	-I$(STAGING_DIR)/usr/include/ar-osal \
	-I$(STAGING_DIR)/usr/include/ar-gsl/api \
	-I$(STAGING_DIR)/usr/include/ar_gsl/inc \
	-I $(TOPDIR)/src/audio/mm-audio-headers/acdbdata/ \
	-I $(STAGING_DIR)/usr/include/glib-2.0/ \
	-I$(STAGING_DIR)/usr/include/ats/

define Build/Prepare
	mkdir -p $(PKG_BUILD_DIR)/
	$(CP) $(LOCAL_SRC)/* $(PKG_BUILD_DIR)/
endef

define Build/InstallDev
	$(INSTALL_DIR) $(STAGING_DIR)
	mkdir -p $(1)/usr/include/agm/
	mkdir -p $(1)/usr/lib/
	$(CP) $(PKG_BUILD_DIR)/inc/*.h $(1)/usr/include/agm/
	$(CP) $(PKG_BUILD_DIR)/.libs/libagm.so* $(1)/usr/lib/
endef

define Package/agm/install
	$(INSTALL_DIR) $(1)/usr/lib
	$(CP) $(PKG_BUILD_DIR)/.libs/libagm.so* $(1)/usr/lib
endef

$(eval $(call BuildPackage,agm))
