package myenum;

import net.mindview.util.Enums;

import static net.mindview.util.Print.*;

import java.util.Iterator;

class Mail {
    enum GeneralDelivery {YES, NO1, NO2, NO3, NO4, NO5}

    enum ScanAbility {无法扫描, YES1, YES2, YES3, YES4}

    enum ReadAbility {无法辨认, YES1, YES2, YES3, YES4}

    enum Address {不正确, OK1, OK2, OK3, OK4, OK5, OK6}

    enum ReturnAddress {缺失, OK1, OK2, OK3, OK4, OK5}

    GeneralDelivery generalDelivery;
    ScanAbility scanAbility;
    ReadAbility readAbility;
    Address address;
    ReturnAddress returnAddress;
    static long counter = 0;
    long id = counter++;

    public String toString() {
        return "《邮件 " + id+"》";
    }

    public String details() {
        return toString() +
                ",普通发送：" + generalDelivery +
                ",地址可扫描：" + scanAbility +
                ",地址是否可读：" + readAbility +
                ",地址是否正确：" + address +
                ",发信地址：" + returnAddress;
    }

    public static Mail randomMail() {
        Mail mail = new Mail();
        mail.generalDelivery = Enums.random(GeneralDelivery.class);
        mail.scanAbility = Enums.random(ScanAbility.class);
        mail.readAbility = Enums.random(ReadAbility.class);
        mail.address = Enums.random(Address.class);
        mail.returnAddress = Enums.random(ReturnAddress.class);
        return mail;
    }

    public static Iterable<Mail> generator(final int count) {
        return new Iterable<Mail>() {
            int n = count;

            @Override
            public Iterator<Mail> iterator() {
                return new Iterator<Mail>() {
                    @Override
                    public boolean hasNext() {
                        return n-- > 0;
                    }

                    @Override
                    public Mail next() {
                        return randomMail();
                    }

                    public void remove() {
                        throw new UnsupportedOperationException();
                    }
                };
            }
        };
    }
}

public class PostOffice {
    enum MailHandler {
        GENERAL_DELIVERY {
            boolean handle(Mail mail) {
                switch (mail.generalDelivery) {
                    case YES:
                        return true;
                    default:
                        return false;
                }
            }
        },
        MACHINE_SCAN {
            boolean handle(Mail mail) {
                switch (mail.scanAbility) {
                    case 无法扫描:
                        return false;
                    default:
                        switch (mail.address) {
                            case 不正确:
                                return false;
                            default:
                                return true;
                        }
                }
            }
        },
        VISUAL_INSPECTION {
            boolean handle(Mail mail) {
                switch (mail.readAbility) {
                    case 无法辨认:
                        return false;
                    default:
                        switch (mail.address) {
                            case 不正确:
                                return false;
                            default:
                                return true;
                        }
                }
            }
        },
        RETURN_TO_SENDER {
            boolean handle(Mail mail) {
                switch (mail.returnAddress) {
                    case 缺失:
                        return false;
                    default:
                        print("把邮件： " + mail + " 寄回发信者");
                        return true;
                }
            }
        };

        abstract boolean handle(Mail mail);
    }

    static void handle(Mail mail) {
        boolean canSend = false;
        loop:for (MailHandler item : MailHandler.values()) {
            canSend = item.handle(mail);
            if(canSend == false){

            }
        }
        if(canSend){
            print("正常发送：《"+mail+"》");
        }else {
            print("《"+mail+"》是一封死信");
        }
    }

    public static void main(String[] args) {
        for (Mail item : Mail.generator(10)) {
            print(item.details());
            handle(item);
            print("*************************");
        }
    }
}
