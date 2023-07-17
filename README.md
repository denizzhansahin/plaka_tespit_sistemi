# plaka_tespit_sistemi
Plaka tanıma ve tespit sistemi kodları yer almaktadır.

Bu repoda sadece hazırlanmış kodlar vardır. Kodların tamamı için bu Google Drive linkini kullanınız , Bu link içindeki tüm dosyaları indiriniz: https://drive.google.com/drive/folders/1N7zvG8pJfCYrLGNjCw6NDGksHJjOZ0GZ?usp=sharing 

Sunum Dosyası için Tıklayınız : https://github.com/denizzhansahin/plaka_tespit_sistemi/blob/main/SunumBGM.pdf

<div align="center">
    <img src="https://github.com/denizzhansahin/plaka_tespit_sistemi/assets/95483485/1e7e14a2-7d00-4b9e-abf4-c06b73e0998e" width="33%">
</div>


Plaka tanıma ve güvenlik sistemi; kamu kurumları, özel sektör kuruluşları, toplu konutlar veya diğer konut türleri için geliştirilmiş bir sistemdir. Proje ile birlikte kullanıcıların karşılaşabileceği güvenlik sorunları için yazılım geliştirilmiştir. Bu yazılım kapsamında çeşitli türlere ait araçların tespit edilmesi ve sahip oldukları plakaların metinsel ifadelerinin tespit edilmesi amaçlanmaktadır. Tespit edilecek plaka bilgisi ile birlikte kullanıcı bilgilerinin yerel bir veritabanı üzerinde depolanması ve bu bilgilerin ilgili kullanıcılar için bulut veritabanı ile eşitlenmesi ve mobil uygulama üzerinden takibinin yapılması amaçlanmaktadır. Plaka tanıma sistemi, içerisinde yer alan derin öğrenme ve bilgisayarlı görü teknolojisi ile birlikte araç ve plaka tespiti yapılmaktadır. Aynı yöntemler ile birlikte plaka üzerinde belirtilen metinsel ifadeler elde edilmektedir. Tespit edilen plaka bilgisi ile veritabanında kayıtlı kullanıcı olması veya olmaması durumları ile birlikte ilgili veritabanı içindeki tablolara veri girişi yapılmaktadır. Ayrıca bu veri girişlerinin bulut veritabanı ile eşitlenmesi sağlanacak olup her bir kullanıcı ve sistem yöneticisi tarafından gerekli bilgiler mobil uygulama üzerinden takip edilebilecektir.

Sistemin ayrıca masaüstü tarafından kontrol edilmesi amacı ile bir masaüstü uygulama geliştirilmiştir. Kullanıcı ekleme, silme ve güncelleme ile araç ekleme, silme ve güncelleme işlemleri yapılmaktadır. Ayrıca veritabanı üzerinde kayıtlı kullanıcılar ve araçlar için giriş/çıkış tabloları, günlük işlem tablosu , veritabanı üzerinde kayıtlı olmayan kullanıcılar için ise yetkisiz giriş/çıkış tablosu oluşturulmuştur. Ayrıca kullanıcı, araç ve zaman dilimler için özel arama tabloları oluşturulmuştur. Sistem yöneticisi için ise bu tablolar hem Excel hem CSV formatında bir dosya haline dönüştürme imkanı verilmiştir. 

Plaka tanıma sistemi aktif olarak çalışan bir kamera görüntüsü ile senkronize olmaktadır. Kamera görüntüsü eş zamanlı olarak üç farklı nesne tanıma algoritması ile birlikte çalışmaktadır. Bu nesne tanıma algoritması is sırası ile araç tespiti, tespit edilen araç ve plaka için koordinat  tespiti yapılması sağlanmıştır. Son iki nesne tespiti algoritması ile hem ilgili aşamaların görselleri kaydedilmektedir ve veritabanına eklenmektedir. Ayrıca plaka üzerinde metinsel ifadelerin tespit edilmesi için ise OCR algoritması kullanılmaktadır. İlgili plaka eğer veritabanı üzerinde kayıtlı olup olmaması ile işlemler son nesne tanıma algoritması içind  gerçekleştirilmektedir. Bu aşamalar esnasında ise yerel veritabanı bilgileri ise bulut veritabanı üzerindeki veri girişleri sağlanacaktır. Böylece verilerin yedeklenmesi ve her bir kullanıcı için mobil uygulama üzerinden ilgili veritabanı işlemlerinin sadece kendileir ile ilgili kısmını takip etmesi imkanı verilecektir.

Plaka tanıma sistemi ile birlikte yaşanabilecek iç ve dış güvenlik tehditleri için güvenlik güçlerine kolaylık sağlanabilecektir. Saatler ve günler süren güvenlik kamerası kayıtları yerine sadece nesne tanıma algoritmaları sayesinde elde edilen görsel ve bilgiler ile kolayca arama ve bulma işlemi yapılabilecektir. Ayrıca veritabanı üzerindeki tüm verilerin transferi ise çok daha kolay taşınabilecektir. Plaka tanıma sistemi ayrıca plakası belli olmayan araçlar için is  ilgili veritabanı işlemleri gerçeklteştirmektedir. Böylece kullanıcı güvenliği ve takibi en üst düzeyde sağlanması planlanmaktadır.


# Kullanılan Teknolojiler
<div align="center">
    <img src="https://github.com/denizzhansahin/plaka_tespit_sistemi/assets/95483485/f13cef80-aa09-4bf7-8bd3-dcb3965bc31a" width="33%">
    <img src="https://github.com/denizzhansahin/plaka_tespit_sistemi/assets/95483485/1f5deccd-63c6-4663-af47-7e0a1e4863a8" width="33%">
    <img src="https://github.com/denizzhansahin/plaka_tespit_sistemi/assets/95483485/d0531f77-0df1-4a54-9a5e-57527de7ca5f" width="33%">
</div>

<div align="center">
    <img src="https://github.com/denizzhansahin/plaka_tespit_sistemi/assets/95483485/a6af04a2-6a46-473c-8e34-bd03c8db0a99" width="33%">
    <img src="https://github.com/denizzhansahin/plaka_tespit_sistemi/assets/95483485/d2ad9d39-c558-47dc-b0da-aee3d1144eb6" width="33%">
    <img src="https://github.com/denizzhansahin/plaka_tespit_sistemi/assets/95483485/1f36f1c2-39d9-41f4-a8c0-4433e780d329" width="33%">
</div>

<div align="center">
    <img src="https://github.com/denizzhansahin/plaka_tespit_sistemi/assets/95483485/fde3dc4a-3114-4dc1-bf10-38d94d274aa9" width="33%">
    <img src="https://github.com/denizzhansahin/plaka_tespit_sistemi/assets/95483485/1d93781a-7ba4-4f12-840e-af96e74d1272" width="33%">
    <img src="https://github.com/denizzhansahin/plaka_tespit_sistemi/assets/95483485/1e9ed696-a8d3-4973-8b13-c9d9f578e685" width="33%">
</div>

<div align="center">
    <img src="https://github.com/denizzhansahin/plaka_tespit_sistemi/assets/95483485/a2d6b4bb-397b-42f9-87ba-de2cbf456d87" width="33%">
    <img src="https://github.com/denizzhansahin/plaka_tespit_sistemi/assets/95483485/2906a9f5-0d55-490a-94b2-61fd86169b03" width="33%">
    <img src="https://github.com/denizzhansahin/plaka_tespit_sistemi/assets/95483485/3d9b2e05-d35f-4054-9a9f-306e787c2cd5" width="33%">

</div>



