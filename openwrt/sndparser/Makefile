include $(TOPDIR)/rules.mk

PKG_NAME:=sndparser
PKG_RELEASE:=1
PKG_FIXUP:=autoreconf

LOCAL_SRC:=$(TOPDIR)/qca/src/vendor/qcom/opensource/audio-graph-mgr/snd_parser
include $(INCLUDE_DIR)/local-development.mk
ifeq ($(DUMP)$(PKG_VERSION),)
  PKG_REV:=$(shell git ls-remote $(PKG_SOURCE_URL) $(PKG_BRANCH) | cut -b -7)
  PKG_VERSION:=g$(PKG_REV)
endif

include $(INCLUDE_DIR)/package.mk

define Package/sndparser
  SECTION:=AUDIO
  CATEGORY:=AUDIO
  DEPENDS:= +libexpat +glib2 +audio-utils +agm
  MAINTAINER:=QTI MM Audio
  TITLE:=SNDPARSER
  SUBMENU:=CASA
endef

define Package/sndparser/description
  This package contails sndparser
endef

CONFIGURE_ARGS += \
                  --with-openwrt \
                  --with-glib

TARGET_CFLAGS += \
                 -I$(STAGING_DIR)/usr/include/glib-2.0/ \
                 -I$(STAGING_DIR)/usr/include/agm/ \
                 -I$(STAGING_DIR)/usr/include/audio_utils/ \
                 -I$(STAGING_DIR)/usr/include/ \
                 -DFEATURE_IPQ_OPENWRT

TARGET_LDFLAGS += \
                 -L$(STAGING_DIR)/usr/lib/

define Build/InstallDev
	$(INSTALL_DIR) $(1)/usr/include/sndparser/
	$(INSTALL_DIR) $(1)/usr/lib/
	$(CP) $(PKG_BUILD_DIR)/inc/*.h $(1)/usr/include/sndparser/
	$(CP) $(PKG_BUILD_DIR)/.libs/libsndcardparser.so $(1)/usr/lib/
endef

define Package/sndparser/install
	$(INSTALL_DIR) $(1)/usr/lib
	$(INSTALL_DIR) $(1)/etc
	$(INSTALL_BIN) $(PKG_BUILD_DIR)/.libs/libsndcardparser.so $(1)/usr/lib
	$(INSTALL_BIN) ./files/ipq6018/*.xml $(1)/etc
endef

$(eval $(call BuildPackage,sndparser))
