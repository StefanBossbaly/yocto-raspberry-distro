SUMMARY = "Transit board production image"

IMAGE_FEATURES:append = " allow-empty-password allow-root-login empty-root-password ssh-server-dropbear"

#IMAGE_INSTALL:append = " rpi-rgb-led-matrix"

LICENSE = "MIT"

# Enable UART on RaspberryPi 0 WiFi and 3
ENABLE_UART = "1"

# Disable vc4graphics
DISABLE_VC4GRAPHICS = "1"

# Disable bluetooth, screen, touchsceen and alsa
MACHINE_FEATURES:remove = "bluetooth"
MACHINE_FEATURES:remove = "screen"
MACHINE_FEATURES:remove = "touchscreen"
MACHINE_FEATURES:remove = "alsa"

inherit core-image