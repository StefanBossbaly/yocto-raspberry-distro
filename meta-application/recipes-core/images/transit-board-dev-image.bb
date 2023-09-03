SUMMARY = "Transit board development image"
LICENSE = "GPL"


inherit core-image
require transit-board-prod-image.bb

IMAGE_INSTALL:append = "\
    transit-board-packagegroup-testapps \
"

EXTRA_IMAGE_FEATURES:append = "\
    debug-tweaks \
    tools-sdk \
"
