SUMMARY = "Transit board development image"

inherit core-image
require transit-board-prod-image.bb

IMAGE_INSTALL:append = " transit-board-packagegroup-testapps septa-api"
IMAGE_FEATURES:append = " debug-tweaks"
