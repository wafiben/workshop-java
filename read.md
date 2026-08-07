┌──> WhatsupMessage
Msg (base) ─┼──> InstagramMessage
└──> MessengerMessage


        WhatsAppStrategy   ─┐
        InstagramStrategy  ─┼──> implements StartegyMessage
        MessengerStrategy  ─┘


Msg subclass          CommunicationType         Strategy subclass
─────────────────      ─────────────────        ─────────────────
InstagramMessage  ──►  CommunicationType.INSTAGRAM  ──►  InstagramStrategy
WhatsupMessage    ──►  CommunicationType.WHATSAPP    ──►  WhatsAppStrategy
MessengerMessage  ──►  CommunicationType.MESSENGER   ──►  MessengerStrategy