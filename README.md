✨ Doctorin Otomasyon Test Projesi

---

🚀 Proje Hakkında

Bu proje, Doctorin platformunun önemli iş akışlarını otomatik olarak test etmek için tasarlanmış bir otomasyon test projesidir. Amacımız, randevu oluşturma, tamamlama ve silme süreçlerinin doğru ve hatasız çalıştığını doğrulamaktır. Proje, sektör standardı araçlar olan Selenium, Java ve Cucumber kullanılarak geliştirilmiştir ve Davranış Odaklı Geliştirme (BDD) metodolojisini benimser.

Doctorin, sağlık ve yaşam hizmeti sunan kişi ve kurumların operasyonlarını tek bir merkezden yönetebilmelerini sağlayan kapsamlı bir platformdur. Platform, hasta kaydı, randevu yönetimi, finansal süreçler ve e-Nabız gibi resmi entegrasyonları kolaylaştırır.

Test Edilen Müşteri: Nişantaşı Klinik

---

🛠️ Test Ortamı

URL: https://testapp.doctorin.app

Müşteri: "Nişantaşı Klinik"

Kullanıcı Adı: Test

Şifre: Test123.

---

✅ Test Senaryoları


1. Kullanıcı Girişi (Login)
   
Kullanıcı, belirlenen Test / Test123. kimlik bilgileriyle sisteme güvenli bir şekilde giriş yapar.

Giriş işlemi sırasında, sayfa yükleme ve butonların tıklanabilir hale gelmesi için açık bekleme (explicit wait) stratejisi kullanılır. Bu, testin kararlılığını artırır ve elementlerin geç yüklenmesi gibi dinamik sayfa yapılarına bağlı hataları engeller.

2. Randevu Akışı (Appointment Flow)
   
Sistemde başarılı bir şekilde oturum açıldıktan sonra Randevu Modülüne geçiş yapılır.

Filtreleme menüsü açılır ve ilgili şube ile departman bilgileri seçilir.

Randevu takviminde bulunan ilk uygun zaman dilimi hücresine tıklanır.

Açılan menüde hasta bilgileri aranır ve doğru hasta seçimi yapılır.

Oluşturulan randevu başarıyla kaydedilir.

Kaydedilen randevunun durumu "Tamamlandı" olarak güncellenir ve bu durum doğrulanır.

Son olarak, test verisinin temizlenmesi için oluşturulan randevu silinir ve silme işleminin başarılı olduğu teyit edilir.

---

🛠️ Kullanılan Araçlar (Tools)

Bu otomasyon projesi, güncel ve sektörde yaygın olarak kullanılan aşağıdaki araç ve teknolojilerle geliştirilmiştir:

Java: Test otomasyon kodlarının yazıldığı temel programlama dilidir.

Selenium WebDriver: Tarayıcı etkileşimlerini (tıklama, veri girişi vb.) otomatikleştirmek için kullanılan popüler bir kütüphanedir.

Cucumber: Davranış odaklı geliştirme (BDD) yaklaşımını benimseyerek, test senaryolarını anlaşılır bir dilde (Gherkin) yazmamızı sağlar.

JUnit: Testlerin çalıştırılması ve sonuçlarının yönetilmesi için kullanılan bir test framework'üdür.

Maven: Proje bağımlılıklarını yönetmek, derlemek ve çalıştırmak için kullanılan güçlü bir proje yönetim aracıdır.

Git: Projenin versiyon kontrolünü sağlamak ve ekip içinde işbirliğini kolaylaştırmak için kullanılır.

---

📂 Proje Yapısı


doctorin_automation_test/
├── src/
│ ├── main/java/utilities/       # 🔧 Driver ve konfigürasyon dosyaları
│ └── test/java/
│     ├── pages/                 # 📄 Sayfa objesi modelleri (POM)
│     ├── stepDefinitions/       # 📝 Cucumber adım tanımları
│     ├── runners/               # 🏃 Test çalıştırıcıları
│     └── utils/                 # 📚 Yardımcı sınıflar (log, bekleme, test verisi)
├── src/test/resources/
│ ├── features/                  # 💡 Cucumber feature dosyaları (Gherkin)
│ └── config.properties          # ⚙️ Konfigürasyon ayarları
├── appointment_module_bugs.md   # 🐞 Bulunan hataların raporu
├── pom.xml                      # 📦 Maven bağımlılıkları ve proje bilgileri
└── README.md                    # 📖 Proje açıklaması ve kullanımı

---

⚙️ Kullanım Kılavuzu

Bu projeyi yerel makinenizde çalıştırmak için aşağıdaki adımları takip edin:

1.Repo'yu klonlayın:

git clone https://github.com/intizarguzelcay/doctorin-automation.git
cd doctorin-automation

2.Proje bağımlılıklarını yükleyin:

mvn clean install

3.Testleri çalıştırın:

mvn test
Testlerinizin başarıyla çalıştığını konsolda göreceksiniz. 🎉

---

