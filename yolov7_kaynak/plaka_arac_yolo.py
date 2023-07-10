#iki model çalıştırma

import threading

from detect_arac import kaynak_bilgi_arac,detect_arac_fonsiyon
from detect_plaka import kaynak_bilgi_plaka,detect_plaka_fonksiyon

import cv2

import pytesseract

import time
from datetime import datetime


import numpy as np
from PIL import Image

import sqlite3 as sql
db = sql.connect("veri_tabani/db.sqlite")
imlec = db.cursor()

"""
kaynak = "/home/denshn/Masaüstü/plaka_tanima/source/plaka210.jpg"

kaynak_bilgi_arac.kaynak = kaynak
kaynak_bilgi_plaka.kaynak = kaynak
"""

def yetkili_arac(plaka,source):
    now = datetime.now()
    ay = str(now.month)
    gun = str(now.day)
    saat = str(now.hour)
    dakika = str(now.minute)
    print(plaka)
    

    islem_gorevi = "Giris/Çıkış"
    veri = (plaka, source, islem_gorevi, ay, gun, saat, dakika)
    db.execute("INSERT INTO yetkili_arac_islem_tablo VALUES (?, ?, ?, ?, ?, ?, ?)", veri)

    db.commit()

def yetkili_kullanici(plaka,source):
    now = datetime.now()
    ay = str(now.month)
    gun = str(now.day)
    saat = str(now.hour)
    dakika = str(now.minute)
    print(plaka)
    imlec.execute("SELECT kullanici_ID FROM arac_bilgileri WHERE plaka= ?",(plaka,))
    kullaniciID = imlec.fetchone()
    
    print(kullaniciID)

    islem_gorevi = "Giris/Çıkış"
    veri = (str(kullaniciID[0]), plaka, source, islem_gorevi, ay, gun, saat, dakika)
    db.execute("INSERT INTO yetkili_kullanici_islem_tablo VALUES (?, ?, ?, ?, ?, ?, ?, ?)", veri)

    db.commit()


def gunluk_islem(plaka,source):
    now = datetime.now()
    ay = str(now.month)
    gun = str(now.day)
    saat = str(now.hour)
    dakika = str(now.minute)
    islem_gorevi = "Giris/Çıkış"
    print(plaka)
    try:
        imlec.execute("SELECT kullanici_ID FROM arac_bilgileri WHERE plaka= ?",(plaka,))
        kullaniciID = imlec.fetchone()
        print(kullaniciID)
        tespit_edilme = str("Plaka Var")
        veri = (str(kullaniciID[0]), plaka, source, islem_gorevi, ay, gun, saat, dakika,tespit_edilme)
    except:
        kullaniciID = "-"
        tespit_edilme = str("Plaka Var")
        veri = (str(kullaniciID), plaka, source, islem_gorevi, ay, gun, saat, dakika,tespit_edilme)
    
    
    imlec.execute("INSERT INTO gunluk_islem_tablo VALUES (?, ?, ?, ?, ?, ?, ?, ?,?)", veri)

    db.commit()


def yetkisiz_arac(plaka,source):
    now = datetime.now()
    ay = str(now.month)
    gun = str(now.day)
    saat = str(now.hour)
    dakika = str(now.minute)

    islem_gorevi = "Giris/Çıkış"
    veri = (plaka, source, islem_gorevi, ay, gun, saat, dakika,"Plaka Var")
    imlec.execute("INSERT INTO yetkisiz_islem_tablo VALUES (?, ?, ?, ?, ?, ?, ?, ?)", veri)

    db.commit()
    

def plakasiz_arac(source):
    now = datetime.now()
    ay = str(now.month)
    gun = str(now.day)
    saat = str(now.hour)
    dakika = str(now.minute)

    islem_gorevi = "Giris/Çıkış"
    veri = ("-", source, islem_gorevi, ay, gun, saat, dakika,"Plaka Yok")
    imlec.execute("INSERT INTO yetkisiz_islem_tablo VALUES (?, ?, ?, ?, ?, ?, ?, ?)", veri)
    veri = ("-", "-", source, islem_gorevi, ay, gun, saat, dakika,"Plaka Yok")
    imlec.execute("INSERT INTO gunluk_islem_tablo VALUES (?, ?, ?, ?, ?, ?, ?, ?,?)", veri)

    db.commit()

def veri_tabani(plaka,source):
    imlec.execute("""SELECT plaka FROM arac_bilgileri""")
    plakalar = imlec.fetchall()
    print(plaka)
    print(len(plaka))

    print("Plakaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa")
    print(plaka[0:9])
    print(len(plaka[0:9]))
    print("Plakaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa")
    
    print(tuple([plaka[0:10]]))
    if tuple([plaka[0:10]]) in plakalar:
        
        #eger yetkili bir kullanici ise
        yetkili_kullanici(plaka[0:10],source)
        gunluk_islem(plaka[0:10],source)
        yetkili_arac(plaka[0:10],source)
    else:
        #eger yetkili bir kullanici degil ama plaka belli ise
        yetkisiz_arac(plaka[0:10],source)
        gunluk_islem(plaka[0:10],source)
      
        

def select_roi(image, x1, y1, x2, y2):
    roi = image[y1:y2, x1:x2]
    return roi

def metin(isim,source):
    try:
        dosya_adi = isim
        
        img = cv2.imread(isim, 0)  # Grayscale image
        norm_img = np.zeros((img.shape[0], img.shape[1]))
        img = cv2.normalize(img, norm_img, 0, 255, cv2.NORM_MINMAX)
        img = cv2.threshold(img, 100, 255, cv2.THRESH_BINARY)[1]
        img = cv2.GaussianBlur(img, (1, 1), 0)
        

        #cv2.imwrite(isim, img)
        plaka_metin = pytesseract.image_to_string(dosya_adi,config='--psm 6 --oem 3')
        print(plaka_metin)
        print(dosya_adi)

    
        
        if plaka_metin == " " or plaka_metin=="" or len(plaka_metin)<1:
            plaka_metin = pytesseract.image_to_string(img)
            if plaka_metin == " " or plaka_metin=="" or len(plaka_metin)<1:
                d = 1/0

        print(plaka_metin)
        print(len(plaka_metin))
        veri_tabani(str(plaka_metin),source)

    
    except:
        print("İşlem başarısız, böyle bir dosya yok veya dosyadaki metin tespit edilemedi.")
        plakasiz_arac(source)

    


#kontrol
kontrol = 0

def kontrol_thread(source2,source1):
    detect_arac_fonsiyon(source2)
    detect_plaka_fonksiyon(source2)
    try:
        if kaynak_bilgi_arac.arac_bilgi[0][0]<=kaynak_bilgi_plaka.plaka_bilgi[0][0] and kaynak_bilgi_arac.arac_bilgi[1][0]>=kaynak_bilgi_plaka.plaka_bilgi[1][0] and kaynak_bilgi_arac.arac_bilgi[0][1]<=kaynak_bilgi_plaka.plaka_bilgi[0][1] and kaynak_bilgi_arac.arac_bilgi[1][1]>=kaynak_bilgi_plaka.plaka_bilgi[1][1]:
            print("Plaka araba görseli içinde")
            global kontrol
            kontrol = 1
            goster_thread(source2,source1)
        else:
            kontrol = 0
            plakasiz_arac(source2)
            #goster_thread(source2,source1)
    except:
        kontrol = 0
        plakasiz_arac(source2)

def goster_thread(source2,source1):
    try:
        while(True):
            # frame üzeri araç tespiti
            try:
                
                print(kaynak_bilgi_arac.arac_bilgi)
                print(kaynak_bilgi_arac.arac_bilgi[0])
                print(kaynak_bilgi_arac.arac_bilgi[1])
                print(kaynak_bilgi_arac.arac_bilgi[2])
                
                print(kaynak_bilgi_plaka.plaka_bilgi)
                print(kaynak_bilgi_plaka.plaka_bilgi[0])
                print(kaynak_bilgi_plaka.plaka_bilgi[1])
                print(kaynak_bilgi_plaka.plaka_bilgi[2])
                
                image = kaynak_bilgi_arac.arac_bilgi[3]
                window_name = 'Image'
                #start_point = kaynak_bilgi_arac.arac_bilgi[0]
                #print(f"Start point : {start_point}")
                #end_point = kaynak_bilgi_arac.arac_bilgi[1]
                #print(f"End point : {end_point}")
                # Blue color in BGR
                color = (255, 0, 0)
                thickness = 5
                #image = cv2.rectangle(image, start_point, end_point, color, thickness)
                #image = cv2.rectangle(image, kaynak_bilgi_plaka.plaka_bilgi[0], kaynak_bilgi_plaka.plaka_bilgi[1], (0,0,255), thickness)
                roi = select_roi(image,kaynak_bilgi_plaka.plaka_bilgi[0][0],kaynak_bilgi_plaka.plaka_bilgi[0][1],kaynak_bilgi_plaka.plaka_bilgi[1][0],kaynak_bilgi_plaka.plaka_bilgi[1][1])
                image = cv2.resize(image,(720,540),interpolation=cv2.INTER_AREA)
                isim = str(source1)+"roi.png"
                print(isim)
                cv2.imwrite(isim,roi)
                metin(isim,source2)
                

               
                """cv2.imshow(window_name, image)
                if cv2.waitKey(1) & 0xFF == ord('q'):
                    break"""

                if True:
                    break
                
            except:
                print("Hata 1")
                """image = cv2.resize(image,(720,540),interpolation=cv2.INTER_AREA)
                cv2.imshow('frame', image)"""
            if cv2.waitKey(1) & 0xFF == ord('q'):
                break
    except:
        print("Hata 2")



#metin()










