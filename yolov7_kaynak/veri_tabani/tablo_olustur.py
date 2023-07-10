import sqlite3 as sql
db = sql.connect("db.sqlite")
imlec = db.cursor()

#############################################################################################################
try:
    imlec.execute("CREATE TABLE kullanici_bilgileri (ad, soyad, kullanici_ID)")
except:
    print("kullanici bilgileri")


try:
    imlec.execute("CREATE TABLE arac_bilgileri (marka, model, uretim_yili,renk,plaka,kullanici_ID)")
except:
    print("araç bilgileri")
#############################################################################################################
try:
    imlec.execute("CREATE TABLE yetkili_kullanici_islem_tablo (kullanici_ID,plaka,dosya_adi,islem_gorevi,islem_ay,islem_gun,islem_saat,islem_dakika)")
except:
    print("yetkili_kullanici_islem_tablo bilgileri")

try:
    imlec.execute("CREATE TABLE yetkili_arac_islem_tablo (plaka, dosya_adi, islem_gorevi,islem_ay,islem_gun,islem_saat,islem_dakika)")
except:
    print("yetkili_arac_islem_tablo bilgileri")

try:
    imlec.execute("CREATE TABLE gunluk_islem_tablo (kullanici_ID, plaka, dosya_adi, islem_gorevi,islem_ay,islem_gun,islem_saat,islem_dakika,plaka_tespit_edilme)")
except:
    print("gunluk_islem_tablo bilgileri")

try:
    imlec.execute("CREATE TABLE yetkisiz_islem_tablo (plaka, dosya_adi, islem_gorevi,islem_ay,islem_gun,islem_saat,islem_dakika,plaka_tespit_edilme)")
except:
    print("yetkisiz_islem_tablo bilgileri")

#############################################################################################################

db.commit()
db.close()