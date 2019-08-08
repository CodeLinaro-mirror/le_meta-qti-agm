include $(TOPDIR)/rules.mk

PKG_NAME:=agm
PKG_RELEASE:=1
PKG_FIXUP:=autoreconf

LOCAL_SRC:=$(TOPDIR)/qca/src/vendor/qcom/opensource/audio-graph-mgr/service
include $(INCLUDE_DIR)/local-development.mk
ifeq ($(DUMP)$(PKG_VERSION),)
  PKG_REV:=$(shell git ls-remote $(PKG_SOURCE_URL) $(PKG_BRANCH) | cut -b -7)
  PKG_VERSION:=g$(PKG_REV)
endif

include $(INCLUDE_DIR)/package.mk

define Package/agm
  SECTION:=AUDIO
  CATEGORY:=AUDIO
  DEPENDS:= +tinyalsa +glib2 +gsl +acdbdata +acdb +qts +audio-utils
  MAINTAINER:=QTI MM Audio
  TITLE:=AGM
  SUBMENU:=CASA
endef

define Package/agm/description
  This package contails agm
endef

CONFIGURE_ARGS += --without-cutils \
                  --with-openwrt

TARGET_CFLAGS += \
                 -I$(STAGING_DIR)/usr/include/gecko/ \
                 -I$(STAGING_DIR)/usr/include/osal/ \
                 -I$(STAGING_DIR)/usr/include/gsl/ \
                 -I$(STAGING_DIR)/usr/include/glib-2.0/ \
                 -I$(STAGING_DIR)/usr/include/acdbdata/ \
                 -I$(STAGING_DIR)/usr/include/acdb/ \
                 -I$(STAGING_DIR)/usr/include/qts/ \
                 -I$(STAGING_DIR)/usr/include/audio_utils/ \
                 -DFEATURE_IPQ_OPENWRT

TARGET_LDFLAGS += \
                 -L$(STAGING_DIR)/usr/lib/

define Build/InstallDev
	$(INSTALL_DIR) $(1)/usr/include/agm/
	$(INSTALL_DIR) $(1)/usr/lib/
	$(CP) $(PKG_BUILD_DIR)/inc/*.h $(1)/usr/include/agm/
	$(CP) $(PKG_BUILD_DIR)/.libs/libagm.so $(1)/usr/lib/
endef

define Package/agm/install
	$(INSTALL_DIR) $(1)/usr/lib
	$(INSTALL_BIN) $(PKG_BUILD_DIR)/.libs/libagm.so $(1)/usr/lib
endef

$(eval $(call BuildPackage,agm))
