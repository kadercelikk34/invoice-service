# İnvoice Service (Satın Alma Onaylama)
===================

Kural: Muhasebe sistemine girilecek yeni fatura bilgisi, o satın alım uzmanının şu ana kadar
girmiş olduğu ONAYLANMIŞ tüm faturaların toplamını belirlenen limitin üzerine çıkarıyorsa
ONAYLANMAZ, limitin üzerine çıkarmıyorsa ONAYLANIR.
LİMİT DEĞERİ, tüm uygulama süresince tüm satın alma uzmanları için aynıdır.
İşlem bilgisi aşağıdaki bilgileri içerir:
● First Name
● Last Name
● E-mail
● Amount
● Product Name
● Bill No
Örnek işlem bilgisi: "John,Doe,john@doe.com,30,USB DISC,TR000"
Her müşteri Ad, Soyad ve E-mail üçlüsü ile tekil bir şekilde tanımlanır. Aynı Ad ve Soyad
bilgisine sahip ama farklı email adresine sahip kişilerin işlemleri ayrı ayrı değerlendirilir.
Senin görevin aşağıdaki isterleri karşılayacak bir web uygulaması yapmak olacak:
● İşlem bilgisi bir form ile girilmeli
● Yeni girilen işlem bilgisi yukarıda bahsedilen kural çalıştırılarak kabul edilmeli veya
reddedilmeli.
○ İşlem sonucu kullanıcıya gösterilmeli.
● Kabul edilen veya reddedilen tüm işlemler listelenmeli.
○ İşlem listesi kabul durumuna göre filtrelenmeli.
○ Seçilen müşteriye ait işlemler listelenmeli.

Örnekler
-------------
İşlem Bilgisi : "John,Doe,john@doe.com,200,TR0001"
Kredi Limit : 200
Sonuç : John Doe'nun işlemi kabul edilir
İşlem Bilgisi : "Jane,Doe,jane@doe.com,201,TR0001"
Kredi Limit : 200
Sonuç : Jane Doe'nun işlemi reddedilir
1. İşlem Bilgisi : "Jane,Doe,jane@doe.com,199,TR0001"
2. İşlem Bilgisi : "Jane,Doe,jane@doe.com,2,TR0002"
Kredi Limit : 200
Sonuç : Jane Doe'nun 2. işlemi reddedilir


Kullandığım teknolojiler
-------------
1.spring-boot projesidir.
2.spring data-jpa , maven ,spring mvc , spring-boot-starter-security  kullanılmıştır.
3.database : h2database
4.FrontEnd Tarafında jsp kullanıldı.
5.Fatura listesi üzerinde filtreleme yapmak için jquery.dataTables kulanılmıştır
6.junit kullanılarak DataJpaTest ve service testleri yazılmıştır
7.Validasyon eklenmiştir
8.HTML, css ,jquery

Uygulamanın Çalıştırılması ve Ekranlar
------------- 
1.projeyi git reposundan çekin ıntelliJ veya eclipse gibi bir ide de açın bilgisayarınızda java kuruluysa InvoiceServiceApplication.java sağ tıklayıp Run edebilirsiniz.
- browserdan http://localhost:8080/login saydasından (john@doe.com, john12345) kullanıcı bilgileriyle login olun
-Yada http://localhost:8080/registration yeni bir hesap oluşturup giriş yapabilrsiniz.

2.Login oldukdan sonra karşınıza dashboard yani üzerinde filtre yapabileceğiniz bir Fatura Listesi  ve Yeni Fatura Ekle butonu bulunuyor.

InvoiceController Ne İŞ Yapar
------------- 
1.http://localhost:8080/invoice da Yeni Fatura eklemek için bir form açılır.
-Fatura Tutarı
-Ürün Adı
-Fatura No bilgileri formdan alınır.

-Bu user a ait daha önce onaylanmış fatura toplamı InvoiceRepository > getAmounts dan databaseden cekilir.
-application.properties içeririnde tanımlanmış olan invoice.credit-limit InvoiceServiceProperties deki getCreditLimit ile alınıp , kredi limitini aşıyorsa 
-Fatura statusu APPROVED ( ONAYLANDI) , NOT_APPROWED (ONAYLANMADI) durumuna göre Invoice datası oluturulup database kaydedilir ve İşlem sonucu kullanıcıya gösterilir.

Ekstradan Yapılacak İşler
------------- 
1.Backend projeleri docker ile containerized yapılabilirdi.
2.Daha fazla junit test ve integration test yazılabilirdi.

