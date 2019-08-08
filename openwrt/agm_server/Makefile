include $(TOPDIR)/rules.mk

PKG_NAME:=agm_server
PKG_RELEASE:=1
PKG_FIXUP:=autoreconf

LOCAL_SRC:=$(TOPDIR)/qca/src/vendor/qcom/opensource/audio-graph-mgr/ipc/agm_server/
include $(INCLUDE_DIR)/local-development.mk
ifeq ($(DUMP)$(PKG_VERSION),)
  PKG_REV:=$(shell git ls-remote $(PKG_SOURCE_URL) $(PKG_BRANCH) | cut -b -7)
  PKG_VERSION:=g$(PKG_REV)
endif

include $(INCLUDE_DIR)/package.mk

define Package/agm_server
  SECTION:=AUDIO
  CATEGORY:=AUDIO
  DEPENDS:= +agm +dbus +glib2 +osal +libstdcpp
  MAINTAINER:=QTI MM Audio
  TITLE:=AGM-SERVER
  SUBMENU:=CASA
endef

define Package/agm_server/description
  This package contails agm-server
endef

CONFIGURE_ARGS += \
                  --with-openwrt \
                  --with-glib \
                  --enable-dbus

TARGET_CFLAGS += \
                 -I$(STAGING_DIR)/usr/include/agm/ \
                 -I$(STAGING_DIR)/usr/include/osal/ \
                 -I$(STAGING_DIR)/usr/lib/dbus-1.0/include/ \
                 -I$(STAGING_DIR)/usr/include/dbus-1.0/ \
                 -I$(STAGING_DIR)/usr/include/glib-2.0/ \
                 -I$(STAGING_DIR)/usr/include/

TARGET_LDFLAGS += \
                 -L$(STAGING_DIR)/usr/lib/

define Build/InstallDev
	$(INSTALL_DIR) $(1)/usr/lib/
	$(INSTALL_DIR) $(1)/usr/bin/
	$(CP) $(PKG_BUILD_DIR)/.libs/libagmserverwrapper.so $(1)/usr/lib/
	$(CP) $(PKG_BUILD_DIR)/.libs/agm_server $(1)/usr/bin/
endef

define Package/agm_server/install
	$(INSTALL_DIR) $(1)/usr/lib
	$(INSTALL_DIR) $(1)/usr/bin/
	$(INSTALL_DIR) $(1)/etc/init.d
	$(INSTALL_BIN) $(PKG_BUILD_DIR)/.libs/libagmserverwrapper.so $(1)/usr/lib
	$(INSTALL_BIN) $(PKG_BUILD_DIR)/.libs/agm_server $(1)/usr/bin/
#	$(INSTALL_BIN) ./files/agm-daemon.init $(1)/etc/init.d/agm-daemon
endef

$(eval $(call BuildPackage,agm_server))
