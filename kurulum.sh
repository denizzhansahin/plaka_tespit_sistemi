#!/bin/bash

#######################################
printf "İlgili Paketler Kuruluyor"
printf "\n"
sudo apt-get install python3-pip
sudo apt-get install python3-opencv
sudo apt-get install python3-pyqt5
sudo apt-get install tesseract-ocr libtesseract-dev libleptonica-dev pkg-config
#######################################


#######################################
printf "\n"
printf "İlgili Kütüphaneler Kuruluyor"

pip3 install --upgrade pip
pip install pillow pytesseract


#git clone https://github.com/WongKinYiu/yolov7
#cd yolov7
#wget https://github.com/WongKinYiu/yolov7/releases/download/v0.1/yolov7.pt
#cd ..
#cp -r  yolov7_kaynak/* yolov7/

pip install -r yolov7/requirements.txt
#######################################

#######################################
cd yolov7/veri_tabani/
python3 tablo_olustur.py
#######################################
