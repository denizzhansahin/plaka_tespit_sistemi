![Kotlin_Icon svg](https://github.com/denizzhansahin/plaka_tespit_sistemi/assets/95483485/eba544e3-8480-4ac1-82ac-d9c301e6c101)
![touchicon-180](https://github.com/denizzhansahin/plaka_tespit_sistemi/assets/95483485/3891251a-a060-40ff-9a29-b682322c14a1)
![Python-logo-notext svg](https://github.com/denizzhansahin/plaka_tespit_sistemi/assets/95483485/c35cdf68-c7f7-4dfb-8b36-0bb5fd4bb23f)
![Qt_logo_2016 svg](https://github.com/denizzhansahin/plaka_tespit_sistemi/assets/95483485/95c1b9f5-abd6-4097-aaf1-eb18e3c0defb)
![800px-OpenCV_Logo_with_text_svg_version svg](https://github.com/denizzhansahin/plaka_tespit_sistemi/assets/95483485/e7743d0f-57b4-489a-9177-a4d64bb8693e)
![Uploading indir (1).png…]()
![pytorch-logo](https://github.com/denizzhansahin/plaka_tespit_sistemi/assets/95483485/42fd9187-05ed-430f-a23f-7394c12be6a8)
# plaka_tespit_sistemi
Plaka tanıma ve tespit sistemi kodları yer almaktadır.

Bu repoda sadece hazırlanmış kodlar vardır. Kodların tamamı için bu Google Drive linkini kullanınız , Bu link içindeki tüm dosyaları indiriniz: https://drive.google.com/drive/folders/1N7zvG8pJfCYrLGNjCw6NDGksHJjOZ0GZ?usp=sharing 

Sunum Dosyası için Tıklayınız : https://github.com/denizzhansahin/plaka_tespit_sistemi/blob/main/SunumBGM.pdf


![plaka_tanima_logo](https://github.com/denizzhansahin/plaka_tespit_sistemi/assets/95483485/1e7e14a2-7d00-4b9e-abf4-c06b73e0998e)



Plaka tanıma ve güvenlik sistemi; kamu kurumları, özel sektör kuruluşları, toplu konutlar veya diğer konut türleri için geliştirilmiş bir sistemdir. Proje ile birlikte kullanıcıların karşılaşabileceği güvenlik sorunları için yazılım geliştirilmiştir. Bu yazılım kapsamında çeşitli türlere ait araçların tespit edilmesi ve sahip oldukları plakaların metinsel ifadelerinin tespit edilmesi amaçlanmaktadır. Tespit edilecek plaka bilgisi ile birlikte kullanıcı bilgilerinin yerel bir veritabanı üzerinde depolanması ve bu bilgilerin ilgili kullanıcılar için bulut veritabanı ile eşitlenmesi ve mobil uygulama üzerinden takibinin yapılması amaçlanmaktadır. Plaka tanıma sistemi, içerisinde yer alan derin öğrenme ve bilgisayarlı görü teknolojisi ile birlikte araç ve plaka tespiti yapılmaktadır. Aynı yöntemler ile birlikte plaka üzerinde belirtilen metinsel ifadeler elde edilmektedir. Tespit edilen plaka bilgisi ile veritabanında kayıtlı kullanıcı olması veya olmaması durumları ile birlikte ilgili veritabanı içindeki tablolara veri girişi yapılmaktadır. Ayrıca bu veri girişlerinin bulut veritabanı ile eşitlenmesi sağlanacak olup her bir kullanıcı ve sistem yöneticisi tarafından gerekli bilgiler mobil uygulama üzerinden takip edilebilecektir.

Sistemin ayrıca masaüstü tarafından kontrol edilmesi amacı ile bir masaüstü uygulama geliştirilmiştir. Kullanıcı ekleme, silme ve güncelleme ile araç ekleme, silme ve güncelleme işlemleri yapılmaktadır. Ayrıca veritabanı üzerinde kayıtlı kullanıcılar ve araçlar için giriş/çıkış tabloları, günlük işlem tablosu , veritabanı üzerinde kayıtlı olmayan kullanıcılar için ise yetkisiz giriş/çıkış tablosu oluşturulmuştur. Ayrıca kullanıcı, araç ve zaman dilimler için özel arama tabloları oluşturulmuştur. Sistem yöneticisi için ise bu tablolar hem Excel hem CSV formatında bir dosya haline dönüştürme imkanı verilmiştir. 

Plaka tanıma sistemi aktif olarak çalışan bir kamera görüntüsü ile senkronize olmaktadır. Kamera görüntüsü eş zamanlı olarak üç farklı nesne tanıma algoritması ile birlikte çalışmaktadır. Bu nesne tanıma algoritması is sırası ile araç tespiti, tespit edilen araç ve plaka için koordinat  tespiti yapılması sağlanmıştır. Son iki nesne tespiti algoritması ile hem ilgili aşamaların görselleri kaydedilmektedir ve veritabanına eklenmektedir. Ayrıca plaka üzerinde metinsel ifadelerin tespit edilmesi için ise OCR algoritması kullanılmaktadır. İlgili plaka eğer veritabanı üzerinde kayıtlı olup olmaması ile işlemler son nesne tanıma algoritması içind  gerçekleştirilmektedir. Bu aşamalar esnasında ise yerel veritabanı bilgileri ise bulut veritabanı üzerindeki veri girişleri sağlanacaktır. Böylece verilerin yedeklenmesi ve her bir kullanıcı için mobil uygulama üzerinden ilgili veritabanı işlemlerinin sadece kendileir ile ilgili kısmını takip etmesi imkanı verilecektir.

Plaka tanıma sistemi ile birlikte yaşanabilecek iç ve dış güvenlik tehditleri için güvenlik güçlerine kolaylık sağlanabilecektir. Saatler ve günler süren güvenlik kamerası kayıtları yerine sadece nesne tanıma algoritmaları sayesinde elde edilen görsel ve bilgiler ile kolayca arama ve bulma işlemi yapılabilecektir. Ayrıca veritabanı üzerindeki tüm verilerin transferi ise çok daha kolay taşınabilecektir. Plaka tanıma sistemi ayrıca plakası belli olmayan araçlar için is  ilgili veritabanı işlemleri gerçeklteştirmektedir. Böylece kullanıcı güvenliği ve takibi en üst düzeyde sağlanması planlanmaktadır.


# Kullanılan Teknolojiler


