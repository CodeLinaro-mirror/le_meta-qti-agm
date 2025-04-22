include $(INCLUDE_DIR)/target.mk
QTIAGM:=agm agmplugin sndparser agmplugintest
ifeq ($(PRPL_VERSION),3.1)
	QTIAGM:=
endif
