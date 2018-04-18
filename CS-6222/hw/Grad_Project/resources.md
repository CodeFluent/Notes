[1] D. Springstead, “MARTA Optimizing TAM Using a Systems Approach”, U.S. Department of Transportation, Federal Transit Administration, 5th State of Good Repair Roundtable, June 3rd, 2015

[2] K. Stouffer, V. Pilliterri, S. Lightman, M. Abrams, A. Hahn, “GUIDE TO INDUSTRIAL CONTROL SYSTEMS (ICS) SECURITY”, NIST Special Publication, 800-82, Revision 2, USA

[3] P. Singh, S. Garg, V. Kumar, Z. Saquib “A Testbed for SCADA Cyber Security and Intrusion Detection”, 2015 International Conference on Cyber Security Of Smart cities, Industrial Control System and Communications (SSIC), 5-7 Aug. 2015

[4] R. B. Roy, “Application   of   SCADA   for   Controlling   Electrical Power System Network” in University of Information Technology & Sciences, Volume 1 Issue 2, Dhaka, Bangladesh, pp.85-97  

[5] R. E. Johnson III, “Survey of SCADA Security Challenges and Potential Attack Vectors”, 2010 International Conference for Internet Technology and Secured Transactions (ICITST), 8-11 Nov. 2010



[https://www.researchgate.net/post/How_to_write_survey_or_review_papers_and_What_sections_should_be_mentioned_in_such_papers](https://www.researchgate.net/post/How_to_write_survey_or_review_papers_and_What_sections_should_be_mentioned_in_such_papers)

[https://ieeexplore.ieee.org/stamp/stamp.jsp?tp=&arnumber=1612765](https://ieeexplore.ieee.org/stamp/stamp.jsp?tp=&arnumber=1612765)
[https://ics.sans.org/media/IT-OT-Convergence-NexDefense-Whitepaper.pdf](https://ics.sans.org/media/IT-OT-Convergence-NexDefense-Whitepaper.pdf)
[https://ieeexplore.ieee.org/stamp/stamp.jsp?tp=&arnumber=6980976](https://ieeexplore.ieee.org/stamp/stamp.jsp?tp=&arnumber=6980976)
[https://ieeexplore.ieee.org/stamp/stamp.jsp?tp=&arnumber=6246111](https://ieeexplore.ieee.org/stamp/stamp.jsp?tp=&arnumber=6246111)
[https://ieeexplore.ieee.org/stamp/stamp.jsp?tp=&arnumber=7906943](https://ieeexplore.ieee.org/stamp/stamp.jsp?tp=&arnumber=7906943)


Main Quote: [https://www.stratus.com/assets/CS-Gas-Transmission.pdf](https://www.stratus.com/assets/CS-Gas-Transmission.pdf)

!------------------------------------- The above is garbage (but interesting)-------------------------------------!

### Intro
- [Wiki article on SCADA](https://en.wikipedia.org/wiki/SCADA)
- [First Gen HMI SCADA](https://www.google.com/url?sa=t&rct=j&q=&esrc=s&source=web&cd=1&ved=0ahUKEwj4ipLW8cDaAhVrc98KHfHeCLwQFggpMAA&url=https%3A%2F%2Fproceedings.asmedigitalcollection.asme.org%2Fdata%2FConferences%2FASMEP%2F83891%2FV005T13A005-83-GT-98.pdf&usg=AOvVaw2hX7ek08soGej20HRxR7Po)
- [CANDU examples, good figures, ASME paper](http://www.iaea.org/inis/collection/NCLCollectionStore/_Public/41/057/41057292.pdf)
- [More CANDU, stuff on control centers, IAEA](https://aris.iaea.org/PDF/ACR-1000.pdf)
-[The only gov info I can find on any web programming attacks, CERT](https://ics-cert.us-cert.gov/sites/default/files/recommended_practices/RP_CaseStudy_XSS_20071024_S508C.pdf)

### Main
- [Siemens slides](https://indico.cern.ch/event/640705/contributions/2599040/attachments/1464254/2262937/ETMUserDays2017Summary-PG.pdf)
- [Siemens catalog](https://cache.industry.siemens.com/dl/files/146/109744146/att_927907/v1/simatic-st80-stpc-complete-english-2017.pdf)
- [Siemens WinCC dashboards](https://www.automation.siemens.com/salesmaterial-as/brochure/en/df_fa_i10077-00-7600_ipdf_wincc_systemoverview_en.pdf)
- [TIA Portal, example attack](https://mall.industry.siemens.com/spice/TSTWeb/#/Start/)
- [Generic SCADA info](https://www.researchgate.net/publication/269666705_Generic_Software_Risk_Management_Framework_for_SCADA_System?enrichId=rgreq-436af25e2df10a94ed7e13ba8ac504d4-XXX&enrichSource=Y292ZXJQYWdlOzI2OTY2NjcwNTtBUzoyMjkxMTg3ODAzNzUwNDBAMTQzMTYzNzU4MjUyOA%3D%3D&el=1_x_3&_esc=publicationCoverPdf)

### Program / Code
- [Conpot](https://github.com/mushorg/conpot) READ FIRST
- [Conpot in Detail paper](https://msmis.eller.arizona.edu/sites/msmis/files/documents/sfs_papers/arthur_jicha_masters_paper.pdf) READ FIRST
- [More Conpot Details from SANS](https://www.sans.org/reading-room/whitepapers/detection/designing-implementing-honeypot-scada-network-35252) READ FIRST
- [Other Honeypots](https://lib.dr.iastate.edu/cgi/viewcontent.cgi?article=3130&context=etd)
- [MANTIS](https://github.com/siemens/django-mantis)
- [MANTIS pdf](https://www.first.org/resources/papers/conference2014/first_2014_-_grobauer-_bernd_-_mantis_20140624.pdf)

### Related CVEs for HMIs
- [GE CVE HMI](https://www.cvedetails.com/cve/CVE-2014-0751/?q=CVE-2014-0751)
- [Simatic PCS7 and WinCC 7.0](https://www.cvedetails.com/cve/CVE-2014-8551/)

### Other
- [Slightly irrelevant, but good paper on virtualization in SCADA](https://ieeexplore.ieee.org/stamp/stamp.jsp?tp=&arnumber=6820114)
- [NIST on SCADA and ICS, very quotable](https://nvlpubs.nist.gov/nistpubs/SpecialPublications/NIST.SP.800-82r2.pdf)
- [PCAPs on Siemens, maybe useful?](https://sourceforge.net/projects/s7commwireshark/files/Sample-captures/)
- [Quotable Stats, 2017 HTTP attacks](https://www.ptsecurity.com/upload/corporate/ww-en/analytics/ICS-Security-2017-eng.pdf)
- [Quotable Stats, 2015 Web Application](https://www.ptsecurity.com/upload/ptcom/PT_Positive_Research_2015_EN_web.pdf)
- [Good Slides, Stuxnet diagram](https://engineering.purdue.edu/VAAMI/ICS-modules.pdf)
- [Good overview of SCADA protocols](https://ac.els-cdn.com/S0167404806000514/1-s2.0-S0167404806000514-main.pdf?_tid=b3c5da7c-c318-42a9-b099-530986f0851c&acdnat=1523841042_9d614954094a5e50671440336173e2fd)
- [Better paper on protocols of SCADA](https://brage.bibsys.no/xmlui/bitstream/handle/11250/2455016/Waagsnes%2C%20Henrik.pdf?sequence=1&isAllowed=y)



