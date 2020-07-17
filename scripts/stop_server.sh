#!/bin/bash
if test -f "/etc/init.d/ms-user"; then
  sudo service ms-user stop
fi